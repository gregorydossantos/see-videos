package com.fiap.gregory.seevideos.domain.service;

import com.fiap.gregory.seevideos.domain.usecase.VideoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class VideoServiceTest {

    @InjectMocks
    VideoService service;

    @Mock
    VideoUseCase useCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("")
    void should_ReturnsSuccess_When_UploadVideo() {
    }

    @Test
    @DisplayName("")
    void should_ReturnsSuccess_When_GetVideos() {
    }

    @Test
    @DisplayName("")
    void should_ReturnsSuccess_When_UpdateVideo() {
    }

    @Test
    @DisplayName("")
    void should_ReturnsSuccess_When_DeleteVideo() {
    }
}