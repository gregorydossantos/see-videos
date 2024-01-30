package com.fiap.gregory.seevideos.domain.usecase;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.useful.ValidatorUseful;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import com.fiap.gregory.seevideos.infra.db.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VideoUseCaseTest {

    @InjectMocks
    VideoUseCase useCase;

    @Mock
    ValidatorUseful validatorUseful;

    @Mock
    VideoRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_ReturnsSuccess_When_UploadVideo() {
        var request = buildMockRequest();
        var video = Mockito.mock(Video.class);

        when(repository.save(Mockito.any(Video.class))).thenReturn(Mono.just(video));

        Mono<Video> result = useCase.uploadVideo(request);
        var response = result.block();
        assertNotNull(response);
    }

    @Test
    void should_ReturnsSuccess_When_GetVideos() {
        when(repository.findAll()).thenReturn(Flux.just(Mockito.mock(Video.class)));

        Flux<Video> result = useCase.getVideos();
        var response = result.blockFirst();
        assertNotNull(response);

    }

    @Test
    void should_ReturnsSuccess_When_UpdateVideo() {}

    @Test
    void should_ReturnsSuccess_When_DeleteVideo() {
        var video = Mockito.mock(Video.class);
        when(repository.deleteById(video.getId())).thenReturn(Mono.empty());

        useCase.deleteVideo(video.getId());

        verify(repository).deleteById(video.getId());
    }

    private VideoRequest buildMockRequest() {
        return VideoRequest.builder()
                .title("Test")
                .description("My first video")
                .url("https://www.see-videos.com/videos")
                .build();
    }

}