package com.fiap.gregory.seevideos.domain.service;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.usecase.VideoUseCase;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VideoService {

    final VideoUseCase useCase;

    public Mono<Video> uploadVideo(VideoRequest request) {
        return useCase.uploadVideo(request);
    }

    public Flux<Video> getVideos() {
        return useCase.getVideos();
    }

    public Mono<Video> updateVideo(String id, VideoRequest request) {
        return useCase.updateVideo(id, request);
    }

    public Mono<Void> deleteVideo(String id) {
        return useCase.deleteVideo(id);
    }

}
