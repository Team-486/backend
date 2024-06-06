package com.team486.traffic.service.area;

import com.team486.traffic.controller.area.AreaViewType;
import com.team486.traffic.repository.area.AreaRepository;
import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;
import com.team486.traffic.service.dto.inquiry.response.AreaAccidentResponse;
import com.team486.traffic.service.dto.inquiry.response.AreaCongestionResponse;
import com.team486.traffic.service.dto.inquiry.AreaDto;
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

    public List<?> showAll(final AreaViewType type) {
        final List<AiAreaTrafficResult> aiAreaTrafficResults = getAiAreaTrafficResults(type);
        final List<String> names = extractedAiIds(aiAreaTrafficResults);
        final List<AreaDto> areas = areaRepository.findAllForCongestion(names);
        final Map<String, AiAreaTrafficResult> resultGroupByAiId = extractedGroupByAiId(aiAreaTrafficResults);
        return areas.stream()
                .map(getMapper(type, resultGroupByAiId))
                .toList();
    }

    public AreaDetailResponse showDetail(final Long areaId) {
        final AreaDetailDto areaDetail = findDetailById(areaId);
        final AiAreaTrafficResult aiAreaTrafficResult = webClientService.getSimpleTrafficResponse(areaDetail.aiId());
        return AreaDetailResponse.of(areaDetail, aiAreaTrafficResult);
    }

    private List<AiAreaTrafficResult> getAiAreaTrafficResults(final AreaViewType type) {
        List<AiAreaTrafficResult> aiAreaTrafficResults = webClientService.getAllTrafficResponse();
        if (type.equals(AreaViewType.ACCIDENT)) {
            return aiAreaTrafficResults.stream()
                    .filter(AiAreaTrafficResult::isAccident)
                    .toList();
        }
        return aiAreaTrafficResults;
    }

    private Function<AreaDto, ?> getMapper(final AreaViewType type,
                                           final Map<String, AiAreaTrafficResult> resultGroupByAiId) {
        if (type.equals(AreaViewType.CONGESTION)) {
            return area -> AreaCongestionResponse.of(area, resultGroupByAiId.get(area.aiId()));
        }

        return area -> AreaAccidentResponse.of(area, resultGroupByAiId.get(area.aiId()));
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
