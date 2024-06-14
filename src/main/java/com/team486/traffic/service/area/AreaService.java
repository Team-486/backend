package com.team486.traffic.service.area;

import com.team486.traffic.controller.area.AreaViewType;
import com.team486.traffic.domain.area.Area;
import com.team486.traffic.repository.area.AreaRepository;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;
import com.team486.traffic.service.dto.inquiry.response.AreaAccidentResponse;
import com.team486.traffic.service.dto.inquiry.response.AreaCongestionResponse;
import com.team486.traffic.service.dto.inquiry.response.AreaDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AreaService {
    private final AreaRepository areaRepository;
    private final AreaWebClientService webClientService;
    private final VideoService videoService;

    public List<?> showAll(final AreaViewType type) {
        final List<AreaTrafficResult> areaTrafficResults = getAiAreaTrafficResults(type);
        final List<String> names = extractedAiIds(areaTrafficResults);
        final List<Area> areas = areaRepository.findAllByAiIds(names);
        final Map<String, AreaTrafficResult> resultGroupByAiId = extractedGroupByAiId(areaTrafficResults);
        return areas.stream()
                .map(getMapper(type, resultGroupByAiId))
                .toList();
    }

    public AreaDetailResponse showDetail(final Long areaId) {
        final AreaDetailDto areaDetail = findDetailById(areaId);
        final AreaTrafficResult areaTrafficResult = webClientService.getSimpleTrafficResponse(areaDetail.aiId());
        final String videoUrl = videoService.getVideoByRoads(areaTrafficResult);
        return AreaDetailResponse.of(areaDetail, areaTrafficResult, videoUrl);
    }

    private List<AreaTrafficResult> getAiAreaTrafficResults(final AreaViewType type) {
        List<AreaTrafficResult> areaTrafficResults = webClientService.getAllTrafficResponse();
        if (type.equals(AreaViewType.ACCIDENT)) {
            return areaTrafficResults.stream()
                    .filter(AreaTrafficResult::isAccident)
                    .toList();
        }
        return areaTrafficResults;
    }

    private Function<Area, ?> getMapper(final AreaViewType type,
                                        final Map<String, AreaTrafficResult> resultGroupByAiId) {
        if (type.equals(AreaViewType.CONGESTION)) {
            return area -> AreaCongestionResponse.of(area, resultGroupByAiId.get(area.getAiId()));
        }

        return area -> AreaAccidentResponse.of(area, resultGroupByAiId.get(area.getAiId()));
    }

    private List<String> extractedAiIds(final List<AreaTrafficResult> areaTrafficResults) {
        return areaTrafficResults.stream()
                .map(AreaTrafficResult::id)
                .toList();
    }

    private Map<String, AreaTrafficResult> extractedGroupByAiId(final List<AreaTrafficResult> areaTrafficResults) {
        return areaTrafficResults.stream()
                .collect(Collectors.toMap(AreaTrafficResult::id, aiAreaTrafficResult -> aiAreaTrafficResult));
    }

    private AreaDetailDto findDetailById(final Long areaId) {
        return areaRepository.findDetailById(areaId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
