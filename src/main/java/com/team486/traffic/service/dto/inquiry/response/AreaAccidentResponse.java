package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.dto.ai.response.AccidentType;
import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.RoadDto;

public record AreaAccidentResponse(Double latitude, Double longitude, AccidentType accidentType, Double radius) {
    public static AreaAccidentResponse of(final Area area, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaAccidentResponse(
                area.getPoint().getLatitude(),
                area.getPoint().getLongitude(),
                aiAreaTrafficResult.roads()
                        .stream()
                        .filter(RoadDto::isAccident)
                        .findAny()
                        .map(RoadDto::accidentType)
                        .get(),
                aiAreaTrafficResult.radius());
    }
}
