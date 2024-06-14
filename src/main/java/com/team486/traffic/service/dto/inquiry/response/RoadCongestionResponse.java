package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.domain.area.Point;
import com.team486.traffic.service.area.DirectionValue;

public record RoadCongestionResponse(DirectionValue direction, Double latitude, Double longitude, Double congestion) {
    public static RoadCongestionResponse of(final Area area, final DirectionValue direction, final Double congestion) {
        final Point point = area.getPointByDirection(direction);
        return new RoadCongestionResponse(direction, point.getLatitude(), point.getLongitude(), congestion);
    }
}
