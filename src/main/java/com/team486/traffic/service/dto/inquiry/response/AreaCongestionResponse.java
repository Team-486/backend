package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;

import java.util.List;

public record AreaCongestionResponse(Long id, String name, Double latitude, Double longitude, Double radius, List<RoadCongestionResponse> roads) {
    public static AreaCongestionResponse of(final Area area, final AreaTrafficResult areaTrafficResult) {
        return new AreaCongestionResponse(
                area.getId(),
                area.getName(),
                area.getPoint().getLatitude(),
                area.getPoint().getLongitude(),
                areaTrafficResult.radius(),
                areaTrafficResult.roads().entrySet()
                        .stream()
                        .map(entry -> RoadCongestionResponse.of(area, entry.getKey(), entry.getValue()))
                        .toList()
        );
    }
}
