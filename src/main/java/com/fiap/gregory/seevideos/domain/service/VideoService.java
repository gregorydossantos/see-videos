package com.fiap.gregory.seevideos.domain.service;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.app.response.VideoResponse;
import com.fiap.gregory.seevideos.domain.usecase.VideoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VideoService {

    final VideoUseCase useCase;

    public void uploadVideo(VideoRequest request) {
        useCase.uploadVideo(request);
    }

    public VideoResponse getVideos() {
        return useCase.getVideos();
    }

    public void updateVideo(Long id, VideoRequest request) {
        useCase.updateVideo(id, request);
    }

    public void deleteVideo(Long id) {
        useCase.deleteVideo(id);
    }

}
