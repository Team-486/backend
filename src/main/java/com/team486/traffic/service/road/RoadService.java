package com.team486.traffic.service.road;

import com.team486.traffic.domain.road.Photo;
import com.team486.traffic.repository.road.RoadRepository;
import com.team486.traffic.service.dto.ai.response.RoadTrafficResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoadService {
    private final RoadRepository roadRepository;
    private final RoadWebClientService webClientService;

    public void showAll() {
        final List<RoadTrafficResponse> trafficResponses = webClientService.getTrafficResponses();
        final Map<Long, List<RoadTrafficResponse>> collect = trafficResponses.stream()
                .collect(Collectors.groupingBy(
                        RoadTrafficResponse::id
                ));
    }

    private Photo findPhotoByRoadId(final Long roadId) {
        return roadRepository.findPhotoById(roadId)
                .orElseThrow(() -> new IllegalArgumentException("invalid id"));
    }
}
