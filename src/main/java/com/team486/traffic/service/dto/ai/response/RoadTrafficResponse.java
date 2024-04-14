package com.team486.traffic.service.dto.ai.response;

import com.team486.traffic.service.dto.Congestion;
import com.team486.traffic.service.dto.Direction;

public record RoadTrafficResponse(Long id, Direction direction, Congestion congestion) {
}
