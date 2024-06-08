package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;

import java.util.List;

public record AreaCongestionResponse(Long id, String name, Double latitude, Double longitude, Double radius, List<RoadCongestionResponse> roads) {
    public static AreaCongestionResponse of(final Area area, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaCongestionResponse(
                area.getId(),
                area.getName(),
                area.getPoint().getLatitude(),
                area.getPoint().getLongitude(),
                aiAreaTrafficResult.radius(),
                aiAreaTrafficResult.roads()
                        .stream()
                        .map(roadDto -> RoadCongestionResponse.of(area, roadDto))
                        .toList()
        );
    }
}
