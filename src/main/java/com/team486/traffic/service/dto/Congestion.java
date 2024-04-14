package com.team486.traffic.service.dto;

import com.team486.traffic.domain.road.Photo;

public enum Congestion {
    SMOOTH,
    NORMAL,
    STAGNANT;

    public String getPhotoUrl(final Photo photo) {
        if (this.equals(SMOOTH)) {
            return photo.getSmooth();
        }

        if (this.equals(NORMAL)) {
            return photo.getNormal();
        }

        if (this.equals(STAGNANT)) {
            return photo.getStagnant();
        }

        throw new IllegalArgumentException();
    }
}
