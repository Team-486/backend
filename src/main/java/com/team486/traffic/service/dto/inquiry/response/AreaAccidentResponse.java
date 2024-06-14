package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.dto.ai.response.AccidentType;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;

public record AreaAccidentResponse(Double latitude, Double longitude, AccidentType accidentType, Double radius) {
    public static AreaAccidentResponse of(final Area area, final AreaTrafficResult areaTrafficResult) {
        return new AreaAccidentResponse(
                area.getPoint().getLatitude(),
                area.getPoint().getLongitude(),
                areaTrafficResult.accidentType(),
                areaTrafficResult.radius()
        );
    }
}
