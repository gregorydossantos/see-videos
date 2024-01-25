package com.fiap.gregory.seevideos.app.rest;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.app.response.VideoResponse;
import com.fiap.gregory.seevideos.domain.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.fiap.gregory.seevideos.domain.useful.CommonsMessages.PATH_ID;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@Tag(name = "Video Controller")
@RequestMapping(value = "/videos", produces = {"application/json"})
public class VideoResource {

    final VideoService service;

    @Operation(summary = "Upload a video", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Upload a video with success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Void>> uploadVideo(@RequestBody VideoRequest request) {
        service.uploadVideo(request);
        return Mono.just(ResponseEntity.status(CREATED).build());
    }

    @Operation(summary = "List of videos order by publication date", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return a list of videos"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Flux<ResponseEntity<VideoResponse>> getVideos() {
        return Flux.just(ResponseEntity.ok(service.getVideos()));
    }

    @Operation(summary = "Update a video", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update a video with success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(value = PATH_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Void>> updateVideo(@PathVariable Long id, @RequestBody VideoRequest request) {
        service.updateVideo(id, request);
        return Mono.just(ResponseEntity.status(ACCEPTED).build());
    }

    @Operation(summary = "Delete a video", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a video with success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(PATH_ID)
    public Mono<ResponseEntity<Void>> deleteVideo(@PathVariable Long id) {
        service.deleteVideo(id);
        return Mono.just(ResponseEntity.status(OK).build());
    }

}

