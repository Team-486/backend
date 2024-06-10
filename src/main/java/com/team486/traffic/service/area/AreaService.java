package com.team486.traffic.service.area;

import com.team486.traffic.controller.area.AreaViewType;
import com.team486.traffic.domain.area.Area;
import com.team486.traffic.repository.area.AreaRepository;
import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.RoadDto;
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
        final List<AiAreaTrafficResult> aiAreaTrafficResults = getAiAreaTrafficResults(type);
        final List<String> names = extractedAiIds(aiAreaTrafficResults);
        final List<Area> areas = areaRepository.findAllByAiIds(names);
        final Map<String, AiAreaTrafficResult> resultGroupByAiId = extractedGroupByAiId(aiAreaTrafficResults);
        return areas.stream()
                .map(getMapper(type, resultGroupByAiId))
                .toList();
    }

    public AreaDetailResponse showDetail(final Long areaId) {
        final AreaDetailDto areaDetail = findDetailById(areaId);
        final AiAreaTrafficResult aiAreaTrafficResult = webClientService.getSimpleTrafficResponse(areaDetail.aiId());
        final String videoUrl = videoService.getVideoByRoads(aiAreaTrafficResult);
        return AreaDetailResponse.of(areaDetail, aiAreaTrafficResult, videoUrl);
    }

    private List<AiAreaTrafficResult> getAiAreaTrafficResults(final AreaViewType type) {
        List<AiAreaTrafficResult> aiAreaTrafficResults = webClientService.getAllTrafficResponse();
        if (type.equals(AreaViewType.ACCIDENT)) {
            return aiAreaTrafficResults.stream()
                    .filter(this::isAccident)
                    .toList();
        }
        return aiAreaTrafficResults;
    }

    private boolean isAccident(final AiAreaTrafficResult aiAreaTrafficResult) {
        return aiAreaTrafficResult.roads()
                .stream()
                .anyMatch(RoadDto::isAccident);
    }

    private Function<Area, ?> getMapper(final AreaViewType type,
                                        final Map<String, AiAreaTrafficResult> resultGroupByAiId) {
        if (type.equals(AreaViewType.CONGESTION)) {
            return area -> AreaCongestionResponse.of(area, resultGroupByAiId.get(area.getAiId()));
        }

        return area -> AreaAccidentResponse.of(area, resultGroupByAiId.get(area.getAiId()));
    }

    private List<String> extractedAiIds(final List<AiAreaTrafficResult> aiAreaTrafficResults) {
        return aiAreaTrafficResults.stream()
                .map(AiAreaTrafficResult::aiId)
                .toList();
    }

    private Map<String, AiAreaTrafficResult> extractedGroupByAiId(final List<AiAreaTrafficResult> aiAreaTrafficResults) {
        return aiAreaTrafficResults.stream()
                .collect(Collectors.toMap(AiAreaTrafficResult::aiId, aiAreaTrafficResult -> aiAreaTrafficResult));
    }

    private AreaDetailDto findDetailById(final Long areaId) {
        return areaRepository.findDetailById(areaId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
