package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDto;

public record AreaCongestionResponse(Long id, String name, Double latitude, Double longitude, Integer congestion, Double radius) {
    public static AreaCongestionResponse of(final AreaDto area, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaCongestionResponse(
                area.id(),
                area.name(),
                area.latitude(),
                area.longitude(),
                aiAreaTrafficResult.congestion(),
                aiAreaTrafficResult.radius()
        );
    }
}
