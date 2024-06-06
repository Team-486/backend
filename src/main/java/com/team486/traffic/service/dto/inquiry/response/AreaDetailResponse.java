package com.team486.traffic.service.dto.inquiry.response;

import com.team486.traffic.service.dto.ai.response.AiAreaTrafficResult;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;

public record AreaDetailResponse(AreaDetailDto detail, Integer congestion) {
    public static AreaDetailResponse of(final AreaDetailDto detail, final AiAreaTrafficResult aiAreaTrafficResult) {
        return new AreaDetailResponse(detail, aiAreaTrafficResult.congestion());
    }
}
