package com.team486.traffic.domain.area;

import com.team486.traffic.service.area.DirectionValue;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Embedded
    private Point point;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AreaType type;

    @Column(nullable = false)
    private String aiId;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "left_lattitude", nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "left_longitude", nullable = false))
    })
    @Embedded
    @Column(nullable = false)
    private Point left;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "right_lattitude", nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "right_longitude", nullable = false))
    })
    @Column(nullable = false)
    @Embedded
    private Point right;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "up_lattitude", nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "up_longitude", nullable = false))
    })
    @Column(nullable = false)
    @Embedded
    private Point up;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "down_lattitude", nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "down_longitude", nullable = false))
    })
    @Column(nullable = false)
    @Embedded
    private Point down;

    public Point getPointByDirection(final DirectionValue directionValue) {
        if (directionValue.equals(DirectionValue.UP)) {
            return up;
        } else if (directionValue.equals(DirectionValue.DOWN)) {
            return down;
        } else if (directionValue.equals(DirectionValue.LEFT)) {
            return left;
        } else if (directionValue.equals(DirectionValue.RIGHT)) {
            return right;
        }

        throw new IllegalArgumentException();
    }
}
