package com.team486.traffic.domain.road;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Embeddable
@EqualsAndHashCode
@Getter
@ToString
public class Point {
    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
}
