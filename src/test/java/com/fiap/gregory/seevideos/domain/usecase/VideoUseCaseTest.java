package com.fiap.gregory.seevideos.domain.usecase;

import com.fiap.gregory.seevideos.infra.db.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class VideoUseCaseTest {

    @InjectMocks
    VideoUseCase useCase;

    @Mock
    VideoRepository repository;

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