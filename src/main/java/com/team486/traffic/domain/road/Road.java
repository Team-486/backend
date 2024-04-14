package com.team486.traffic.domain.road;

import jakarta.persistence.*;

@Entity
@Table(name = "road")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)    // TODO: 4/11/24 S3 사용 전까지 nullable = true 로 설정
    @Embedded
    private Photo photo;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "start_point_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "start_point_longitude"))
    })
    @Column(nullable = false)
    @Embedded
    private Point startPoint;

    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "end_point_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "end_point_longitude"))
    })
    @Column(nullable = false)
    @Embedded
    private Point endPoint;
}
