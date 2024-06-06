package com.team486.traffic.service.dto.inquiry;

import com.team486.traffic.domain.area.AreaType;

public record AreaDetailDto(String name, String aiId, AreaType type, String videoUrl) {
    public AreaDetailDto {
    }
}
