package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.service.area.DirectionValue;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;

import java.util.Map;

public record AreaDetailResponse(String name, String type, Map<DirectionValue, Double> roads, String videoUrl) {
    public static AreaDetailResponse of(final AreaDetailDto detail, final AreaTrafficResult areaTrafficResult, final String videoUrl) {
        return new AreaDetailResponse(
                detail.name(),
                detail.type().name(),
                areaTrafficResult.roads(),
                videoUrl
        );
    }
}
