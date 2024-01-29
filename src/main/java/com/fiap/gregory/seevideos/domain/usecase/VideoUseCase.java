package com.fiap.gregory.seevideos.domain.usecase;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.exception.DataNotFoundOrEmptyException;
import com.fiap.gregory.seevideos.domain.useful.ValidatorUseful;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import com.fiap.gregory.seevideos.infra.db.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import static com.fiap.gregory.seevideos.domain.useful.CommonsMessages.DATA_NOT_FOUND_OR_EMPTY;

@Service
@AllArgsConstructor
public class VideoUseCase {

    final VideoRepository videoRepository;
    final ValidatorUseful validatorUseful;

    public Mono<Video> uploadVideo(VideoRequest request) {
        validatorUseful.validateRequest(request);
        return videoRepository.save(buildVideo(request));
    }

    public Flux<Video> getVideos() {
        return videoRepository.findAll();
    }

    public Mono<Video> updateVideo(String id, VideoRequest request) {
        validatorUseful.validateRequest(request);

        var video = videoRepository.findById(id).block();
        if (Objects.isNull(video)) {
            throw new DataNotFoundOrEmptyException(DATA_NOT_FOUND_OR_EMPTY);
        }

        return videoRepository.save(toUpdateVideo(request, video));
    }

    public Mono<Void> deleteVideo(String id) {
        return videoRepository.deleteById(id);
    }

    private Video buildVideo(VideoRequest request) {
        return Video.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .url(request.getUrl())
                .publicationDate(Date.from(Instant.now()))
                .build();
    }

    private Video toUpdateVideo(VideoRequest request, Video video) {
        video.setTitle(request.getTitle());
        video.setDescription(request.getDescription());
        video.setUrl(request.getUrl());
        video.setPublicationDate(Date.from(Instant.now()));
        return video;
    }

}
