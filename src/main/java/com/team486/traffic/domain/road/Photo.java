package com.team486.traffic.domain.road;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Photo {
    @Column(name = "smooth_photo", nullable = false)
    private String smooth;

    @Column(name = "normal_photo", nullable = false)
    private String normal;

    @Column(name = "congest_photo", nullable = false)
    private String congest;
}
