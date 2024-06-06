package com.team486.traffic.controller.area;

import com.team486.traffic.service.area.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/areas")
public class AreaController {
    private final AreaService areaService;

    @GetMapping
    public ResponseEntity<?> getAllRoads(@RequestParam(name = "type") final AreaViewType type) {
        return ResponseEntity.ok(areaService.showAll(type));
    }

    @GetMapping("/{areaId}")
    public ResponseEntity<?> getDetail(@PathVariable("areaId") final Long areaId) {
        return ResponseEntity.ok(areaService.showDetail(areaId));
    }
}
