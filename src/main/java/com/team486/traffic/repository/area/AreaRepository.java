package com.team486.traffic.repository.area;

import com.team486.traffic.domain.area.Area;
import com.team486.traffic.service.dto.inquiry.AreaDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    @Query("SELECT a FROM Area a " +
            "WHERE a.aiId IN :aiIds")
    List<Area> findAllByAiIds(@Param("aiIds") final List<String> aiIds);

    @Query("SELECT NEW com.team486.traffic.service.dto.inquiry.AreaDetailDto(a.name, a.aiId, a.type) " +
            "FROM Area a " +
            "WHERE a.id =:id")
    Optional<AreaDetailDto> findDetailById(@Param("id") final Long id);
}
