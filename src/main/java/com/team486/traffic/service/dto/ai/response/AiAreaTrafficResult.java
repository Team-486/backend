package com.team486.traffic.service.dto.ai.response;

public record AiAreaTrafficResult(String aiId, Integer congestion, Double radius, Boolean isAccident, String accidentType) {
}
