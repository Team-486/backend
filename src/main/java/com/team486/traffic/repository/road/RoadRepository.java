package com.team486.traffic.repository.road;

import com.team486.traffic.domain.road.Photo;
import com.team486.traffic.domain.road.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoadRepository extends JpaRepository<Road, Long> {
    @Query("SELECT r.photo FROM Road r WHERE r.id =: id")
    Optional<Photo> findPhotoById(final Long id);
}
