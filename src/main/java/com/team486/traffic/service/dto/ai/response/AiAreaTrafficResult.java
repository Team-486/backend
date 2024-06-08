package com.team486.traffic.service.dto.ai.response;

import java.util.List;

public record AiAreaTrafficResult(String aiId,
                                  Double radius,
                                  List<RoadDto> roads) {
}
