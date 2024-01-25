package com.fiap.gregory.seevideos.app.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VideoRequest {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String url;

    @NotNull
    @NotBlank
    private Date publicationDate;
}
