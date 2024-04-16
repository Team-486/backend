package com.team486.traffic.controller;

import com.team486.traffic.service.road.RoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoadController {
    private final RoadService roadService;

    @GetMapping("/roads")
    public ResponseEntity<?> findAllRoads() {
        return null;
    }
}
