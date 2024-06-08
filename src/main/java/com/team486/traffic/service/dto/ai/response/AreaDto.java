package com.team486.traffic.service.dto.ai.response;

import java.util.List;

public record AreaDto(Integer radius, List<RoadDto> roads) {
}
