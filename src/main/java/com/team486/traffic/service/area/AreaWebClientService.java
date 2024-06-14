package com.team486.traffic.service.area;

import com.team486.traffic.error.area.exception.AreaException;
import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.RoadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.team486.traffic.error.area.code.AreaErrorCode.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class AreaWebClientService {
    private static final Map<String, Map<DirectionValue, RoadDto>> mockingMap = new HashMap<>();
    private static final String AREA_INFO_URI = "http://3.34.154.250:5000/get_spf";

    private final WebClient webClient;

    /**
     * AI 서버로부터 받을 도로별 혼잡도
     * 응답값을 Mocking 한 상태
     *
     * @return List<AreaDto>
     * @author kim min-woo
     */
    public List<AreaTrafficResult> getAllTrafficResponse() {
        final List<AiAreaTrafficResult> results = getAiAreaTrafficResults();
        return results.stream()
                .map(AreaTrafficResult::from)
                .toList();
    }

    public AreaTrafficResult getSimpleTrafficResponse(final String aiId) {
        final List<AiAreaTrafficResult> aiAreaTrafficResults = getAiAreaTrafficResults();
        return aiAreaTrafficResults.stream()
                .filter(aiAreaTrafficResult -> aiAreaTrafficResult.id().equals(aiId))
                .findAny()
                .map(AreaTrafficResult::from)
                .orElseThrow(() -> new AreaException(NOT_FOUND));
    }

    private List<AiAreaTrafficResult> getAiAreaTrafficResults() {
        return webClient.get()
                .uri(AREA_INFO_URI)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AiAreaTrafficResult>>() {
                })
                .block();
    }
}
