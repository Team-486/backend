package com.team486.traffic.service.dto.ai.response;

public record AiAreaTrafficResult(String id,
                                  Double radius,
                                  Double congestion,
                                  Boolean isAccident,
                                  AccidentType accidentType) {
}
