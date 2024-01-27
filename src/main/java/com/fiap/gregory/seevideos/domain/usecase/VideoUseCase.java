package com.fiap.gregory.seevideos.domain.usecase;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.useful.ValidatorUseful;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import com.fiap.gregory.seevideos.infra.db.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VideoUseCase {

    final VideoRepository videoRepository;
    final ModelMapper modelMapper;
    final ValidatorUseful validatorUseful;

    public Mono<Video> uploadVideo(VideoRequest request) {
        validatorUseful.validateRequest(request);

        var video = modelMapper.map(request, Video.class);
        videoRepository.save(video);

        return Mono.just(video);
    }

    public Flux<Video> getVideos() {
        return Flux.just(videoRepository.findAll())
                .map(video -> modelMapper.map(video, Video.class));
    }

    public Mono<Video> updateVideo(String id, VideoRequest request) {
        return Mono.just(videoRepository.findById(id))
                .map(video -> modelMapper.map(request, Video.class))
                .flatMap(videoRepository::save);
    }

    public Mono<Void> deleteVideo(String id) {
        return Mono.just(videoRepository.deleteById(id)).then();
    }

}
