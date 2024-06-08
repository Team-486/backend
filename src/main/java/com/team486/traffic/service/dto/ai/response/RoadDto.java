package com.team486.traffic.service.dto.ai.response;

import com.team486.traffic.service.area.DirectionValue;

public record RoadDto(DirectionValue direction, Integer congestion, Boolean isAccident, AccidentType accidentType) {
}
