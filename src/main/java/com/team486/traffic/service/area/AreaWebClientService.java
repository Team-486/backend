package com.team486.traffic.service.area;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AreaWebClientService {
    private final WebClient webClient;

    /**
     * AI 서버로부터 받을 도로별 혼잡도
     * 응답값을 Mocking 한 상태
     *
     * @return List<AreaDto>
     * @author kim min-woo
     */
    public List<AiAreaTrafficResult> getAllTrafficResponse() {
        return List.of(
                new AiAreaTrafficResult("spfA", 21, 1.6, false, null),
                new AiAreaTrafficResult("spfB", 15, 1.3, false, null),
                new AiAreaTrafficResult("spfC", 45, 1.2, true, "CAR_TO_CAR"),
                new AiAreaTrafficResult("spfD", 45, 1.2, true, "CAR_TO_CAR"),
                new AiAreaTrafficResult("spfE", 45, 1.2, true, "CAR_TO_CAR"),
                new AiAreaTrafficResult("spfF", 45, 1.2, true, "CAR_TO_CAR")
        );
    }

    public AiAreaTrafficResult getSimpleTrafficResponse(final String aiId) {
        return new AiAreaTrafficResult("spfA", 45, 1.2, true, "CAR_TO_CAR");
    }
}
