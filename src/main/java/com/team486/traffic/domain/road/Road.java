package com.team486.traffic.domain.road;

import com.team486.traffic.domain.spot.Spot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "road")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Embedded
    private Photo photo;

    @JoinColumn(name = "start_spot_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Spot startSpot;

    @JoinColumn(name = "end_spot_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Spot endSpot;

    @Override
    public String toString() {
        return "Road{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo=" + photo +
                ", startSpot=" + startSpot +
                ", endSpot=" + endSpot +
                '}';
    }
}
