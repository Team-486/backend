package com.team486.traffic.service.road;

import com.team486.traffic.service.dto.ai.response.RoadTrafficResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.team486.traffic.service.dto.Congestion.NORMAL;
import static com.team486.traffic.service.dto.Congestion.SMOOTH;
import static com.team486.traffic.service.dto.Direction.*;

@RequiredArgsConstructor
@Service
public class RoadWebClientService {
    private final WebClient webClient;

    /**
     * AI 서버로부터 받을 도로별 혼잡도
     * 응답값을 Mocking 한 상태
     *
     * @author  kim min-woo
     * @return List<RoadTrafficResponse>
     */
    public List<RoadTrafficResponse> getTrafficResponses() {
        return List.of(
                new RoadTrafficResponse(1L, UP, NORMAL),
                new RoadTrafficResponse(1L, DOWN, SMOOTH),
                new RoadTrafficResponse(2L, UP, SMOOTH),
                new RoadTrafficResponse(2L, DOWN, SMOOTH),
                new RoadTrafficResponse(3L, LEFT, SMOOTH),
                new RoadTrafficResponse(3L, RIGHT, NORMAL)
        );
    }
}
