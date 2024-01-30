package com.fiap.gregory.seevideos.app.exception;

import com.fiap.gregory.seevideos.domain.exception.BadRequestException;
import com.fiap.gregory.seevideos.domain.exception.DataNotFoundOrEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.fiap.gregory.seevideos.domain.useful.CommonsMessages.BAD_REQUEST;
import static com.fiap.gregory.seevideos.domain.useful.CommonsMessages.DATA_NOT_FOUND_OR_EMPTY;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeeVideoExceptionHandlerTest {

        @InjectMocks
        private SeeVideoExceptionHandler exceptionHandler;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        @DisplayName("Should be return BadRequestException")
        void testWhenRequestComesWithError() {
            ResponseEntity<StandardError> response = exceptionHandler.badRequestException(
                    new BadRequestException(BAD_REQUEST));
            assertNotNull(response);
        }

    @Test
    @DisplayName("Should be return DataNotFoundOrEmptyException")
    void should_ReturnsDataNotFoundOrEmptyException_When_Not_Found_A_Video() {
        ResponseEntity<StandardError> response = exceptionHandler.dataNotFoundException(
                new DataNotFoundOrEmptyException(DATA_NOT_FOUND_OR_EMPTY));
        assertNotNull(response);
    }

    }