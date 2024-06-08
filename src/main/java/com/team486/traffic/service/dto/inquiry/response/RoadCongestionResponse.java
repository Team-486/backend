package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.area.DirectionValue;
import com.team486.traffic.service.dto.ai.response.RoadDto;

public record RoadCongestionResponse(DirectionValue direction, Double latitude, Double longitude, Integer congestion) {
    public static RoadCongestionResponse of(final Area area, final RoadDto roadDto) {
        if (roadDto.direction().equals(DirectionValue.UP)) {
            return new RoadCongestionResponse(roadDto.direction(), area.getUp().getLatitude(), area.getUp().getLongitude(), roadDto.congestion());
        }
        if (roadDto.direction().equals(DirectionValue.DOWN)) {
            return new RoadCongestionResponse(roadDto.direction(), area.getDown().getLatitude(), area.getDown().getLongitude(), roadDto.congestion());
        }
        if (roadDto.direction().equals(DirectionValue.LEFT)) {
            return new RoadCongestionResponse(roadDto.direction(), area.getLeft().getLatitude(), area.getLeft().getLongitude(), roadDto.congestion());
        }
        if (roadDto.direction().equals(DirectionValue.RIGHT)) {
            return new RoadCongestionResponse(roadDto.direction(), area.getRight().getLatitude(), area.getRight().getLongitude(), roadDto.congestion());
        }

        throw new IllegalStateException();
    }
}
