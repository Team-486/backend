package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDto;

public record AreaAccidentResponse(AreaDto area, String accidentType, Double radius) {
    public static AreaAccidentResponse of(final AreaDto area, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaAccidentResponse(area, aiAreaTrafficResult.accidentType(), aiAreaTrafficResult.radius());
    }
}
