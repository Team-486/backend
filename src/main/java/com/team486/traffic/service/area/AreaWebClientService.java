package com.team486.traffic.service.area;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.RoadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.team486.traffic.service.area.DirectionValue.DOWN;
import static com.team486.traffic.service.area.DirectionValue.LEFT;
import static com.team486.traffic.service.area.DirectionValue.RIGHT;
import static com.team486.traffic.service.area.DirectionValue.UP;
import static com.team486.traffic.service.dto.ai.response.AccidentType.CAR_TO_CAR;
import static com.team486.traffic.service.dto.ai.response.AccidentType.CAR_TO_PERSON;

@RequiredArgsConstructor
@Service
public class AreaWebClientService {
    private static final String HOST = "";


//    data[key] = {
//        "congestion": spf_values[key]["congestion"],
//        "up_dir": spf_values[key]["up_dir"],
//        "left_dir": spf_values[key]["left_dir"],
//        "radius": 0.2,
//        "isAccident": accident_status[road_key]["isAccident"],
//        "accidentType": accident_status[road_key]["accidentType"]
//    }
    private final WebClient webClient;

    /**
     * AI 서버로부터 받을 도로별 혼잡도
     * 응답값을 Mocking 한 상태
     *
     * @return List<AreaDto>
     * @author kim min-woo
     */
    public List<AiAreaTrafficResult> getAllTrafficResponse() {
//        webClient.get()
//                .uri(HOST)
//                .retrieve()
//                .bodyToMono(AiAreaTrafficResult.class)
//                .block();
        return List.of(
                new AiAreaTrafficResult("spfA", 1.6,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, false, null)
                        )
                ),
                new AiAreaTrafficResult("spfB", 1.2,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, false, null)
                        )
                ),
                new AiAreaTrafficResult("spfC", 1.2,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, false, null)
                        )
                ),
                new AiAreaTrafficResult("spfD", 1.2,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, false, null)
                        )
                ),
                new AiAreaTrafficResult("spfE", 1.2,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, false, CAR_TO_PERSON)
                        )
                ),
                new AiAreaTrafficResult("spfF", 1.2,
                        List.of(
                                new RoadDto(UP, 20, false, null),
                                new RoadDto(DOWN, 20, false, null),
                                new RoadDto(LEFT, 20, false, null),
                                new RoadDto(RIGHT, 20, true, CAR_TO_CAR)
                        )
                )
        );
    }

    public AiAreaTrafficResult getSimpleTrafficResponse(final String aiId) {
        return new AiAreaTrafficResult("spfF", 1.2,
                List.of(
                        new RoadDto(UP, 20, false, null),
                        new RoadDto(DOWN, 20, false, null),
                        new RoadDto(LEFT, 20, false, null),
                        new RoadDto(RIGHT, 20, true, CAR_TO_CAR)
                )
        );
    }
}
