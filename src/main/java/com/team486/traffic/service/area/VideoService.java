package com.team486.traffic.service.area;

import com.team486.traffic.service.dto.ai.response.AccidentType;
import com.team486.traffic.service.dto.ai.response.AreaTrafficResult;
import com.team486.traffic.service.dto.video.request.AiVideoRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoService {
    private static final Map<String, String> videos = new HashMap<>();

    static {
        videos.put("spfA", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvA.mp4");
        videos.put("spfB", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvB.mp4");
        videos.put("spfC", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvC.mp4");
        videos.put("spfD", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvD.mp4");
        videos.put("spfE", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvE.mp4");
        videos.put("spfF", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/cctvF.mp4");
        videos.put("crash1", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/crash1.mp4");
        videos.put("crash2", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/crash2.mp4");
        videos.put("crash3", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/crash3.mp4");
        videos.put("crash4", "https://team486-cctvvideo.s3.ap-northeast-2.amazonaws.com/crash4.mp4");
    }

    public AiVideoRequest getVideoRequest() {
        return new AiVideoRequest(getVideos());
    }

    public String getVideoByRoads(final AreaTrafficResult areaTrafficResult) {
        if (areaTrafficResult.isAccident()) {
            final AccidentType accidentType = areaTrafficResult.accidentType();
            return getVideoByAccidentType(accidentType);
        }

        final String aiId = areaTrafficResult.id();
        return getVideoByAiId(aiId);
    }

    private List<String> getVideos() {
        return List.of(
                videos.get("spfA"),
                videos.get("spfB"),
                videos.get("spfC"),
                videos.get("spfD"),
                videos.get("spfE"),
                videos.get("spfF")
        );
    }

    private String getVideoByAiId(final String aiId) {
        return videos.get(aiId);
    }

    private String getVideoByAccidentType(final AccidentType accidentType) {
        if (accidentType.equals(AccidentType.CAR_TO_CAR)) {
            return videos.get("crash1");
        }

        return videos.get("crash3");
    }
}
