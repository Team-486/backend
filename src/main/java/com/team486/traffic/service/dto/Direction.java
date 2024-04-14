package com.team486.traffic.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    LEFT("left"),
    RIGHT("right"),
    UP("up"),
    DOWN("down");

    private final String description;
}
