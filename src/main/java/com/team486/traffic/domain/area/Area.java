package com.team486.traffic.domain.area;

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
    private String videoUrl;

    @Column(nullable = false)
    private String aiId;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", type=" + type +
                ", videoUrl='" + videoUrl + '\'' +
                ", aiId='" + aiId + '\'' +
                '}';
    }
}
