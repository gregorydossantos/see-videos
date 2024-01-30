package com.fiap.gregory.seevideos.app.rest;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.service.VideoService;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class VideoResourceTest {

    @InjectMocks
    VideoResource resource;

    @Mock
    VideoService service;

    @Test
    @DisplayName("Upload a new video")
    void should_ReturnsSuccess_When_UploadVideo() {
        var request = buildRequest();
        when(service.uploadVideo(any())).thenReturn(Mono.just(buildMockVideo()));
        StepVerifier.create(resource.uploadVideo(request)).expectSubscription().expectNext().expectComplete();
    }

    @Test
    @DisplayName("Return a list of videos")
    void should_ReturnsSuccess_When_GetVideos() {
        when(service.getVideos()).thenReturn(Flux.just(buildMockVideo()));
        StepVerifier.create(resource.getVideos()).expectSubscription().expectNext().expectComplete();
    }

    @Test
    @DisplayName("Update a video")
    void should_ReturnsSuccess_When_UpdateVideo() {
        var request = buildRequest();
        var video = buildMockVideo();
        when(service.updateVideo(anyString(), request)).thenReturn(Mono.just(buildMockVideo()));
        StepVerifier.create(resource.updateVideo(video.getId(), request)).expectSubscription().expectNext().expectComplete();
    }

    @Test
    @DisplayName("Delete a video")
    void should_ReturnsSuccess_When_DeleteVideo() {
        var video = buildMockVideo();
        when(service.deleteVideo(anyString())).thenReturn(Mono.just(any(Void.class)));
        StepVerifier.create(resource.deleteVideo(video.getId())).expectSubscription().expectNext().expectComplete();
    }

    private VideoRequest buildRequest() {
        return VideoRequest.builder()
                .title("Test")
                .description("Test the app see-video")
                .url("https://www.see-video.com/")
                .build();
    }

    private Video buildMockVideo() {
        return Video.builder()
                .id(UUID.randomUUID().toString())
                .title("Test")
                .description("Test to see video in streaming")
                .url("https://www.see-video.com/video-one")
                .publicationDate(Date.from(Instant.now()))
                .build();
    }
}