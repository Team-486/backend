package com.team486.traffic.service.dto.ai.response;

import com.team486.traffic.service.area.DirectionValue;

import java.util.Map;

public record AreaTrafficResult(String id,
                                Double radius,
                                Boolean isAccident,
                                AccidentType accidentType,
                                Map<DirectionValue, Double> roads) {
    public static AreaTrafficResult from(final AiAreaTrafficResult aiAreaTrafficResult) {
        final String id = aiAreaTrafficResult.id();
        final Double congestion = aiAreaTrafficResult.congestion();
        if (id.equals("spfA")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, congestion + 5,
                            DirectionValue.RIGHT, Math.max(congestion - 5, 0),
                            DirectionValue.UP, congestion + 5,
                            DirectionValue.DOWN, Math.max(congestion - 5, 0)
                    )
            );
        }

        if (id.equals("spfB")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, congestion,
                            DirectionValue.RIGHT, congestion,
                            DirectionValue.UP, congestion + 1,
                            DirectionValue.DOWN, Math.max(congestion - 1, 0)
                    )
            );
        }

        if (id.equals("spfC")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, 0.,
                            DirectionValue.RIGHT, 0.,
                            DirectionValue.UP, congestion + 5,
                            DirectionValue.DOWN, Math.max(congestion - 5, 0)
                    )
            );
        }

        if (id.equals("spfD")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, congestion + 5,
                            DirectionValue.RIGHT, congestion,
                            DirectionValue.UP, congestion + 5,
                            DirectionValue.DOWN, congestion
                    )
            );
        }

        if (id.equals("spfE")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, congestion,
                            DirectionValue.RIGHT, congestion,
                            DirectionValue.UP, congestion + 2,
                            DirectionValue.DOWN, congestion + 2
                    )
            );
        }

        if (id.equals("spfF")) {
            return new AreaTrafficResult(
                    id,
                    aiAreaTrafficResult.radius(),
                    aiAreaTrafficResult.isAccident(),
                    aiAreaTrafficResult.accidentType(),
                    Map.of(
                            DirectionValue.LEFT, congestion,
                            DirectionValue.RIGHT, congestion + 5,
                            DirectionValue.UP, congestion + 5,
                            DirectionValue.DOWN, congestion
                    )
            );
        }

        return null;
    }
}
