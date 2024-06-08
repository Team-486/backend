package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.ai.response.RoadDto;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;

import java.util.List;

public record AreaDetailResponse(String name, String type, List<RoadDto> roads, String videoUrl) {
    public static AreaDetailResponse of(final AreaDetailDto detail, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaDetailResponse(
                detail.name(),
                detail.type().name(),
                aiAreaTrafficResult.roads(),
                detail.videoUrl()
        );
    }
}
