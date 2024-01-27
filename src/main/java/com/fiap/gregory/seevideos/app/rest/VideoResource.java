package com.fiap.gregory.seevideos.app.rest;

import com.fiap.gregory.seevideos.app.request.VideoRequest;
import com.fiap.gregory.seevideos.domain.service.VideoService;
import com.fiap.gregory.seevideos.infra.db.model.Video;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
    public Mono<Video> uploadVideo(@RequestBody VideoRequest request) {
        return service.uploadVideo(request);
    }

    @Operation(summary = "List of videos order by publication date", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return a list of videos"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Flux<Video> getVideos() {
        return service.getVideos();
    }

    @Operation(summary = "Update a video", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update a video with success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(value = PATH_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Video> updateVideo(@PathVariable String id, @RequestBody VideoRequest request) {
        return service.updateVideo(id, request);
    }

    @Operation(summary = "Delete a video", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a video with success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(PATH_ID)
    public Mono<Void> deleteVideo(@PathVariable String id) {
        return service.deleteVideo(id);
    }

}

