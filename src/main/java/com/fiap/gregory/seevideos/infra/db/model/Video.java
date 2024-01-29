package com.fiap.gregory.seevideos.infra.db.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collation = "videos")
public class Video {

    @Id
    private String id;
    private String title;
    private String description;
    private String url;
    private Date publicationDate;

}
