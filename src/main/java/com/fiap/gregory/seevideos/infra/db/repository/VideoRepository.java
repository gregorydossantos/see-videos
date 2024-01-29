package com.fiap.gregory.seevideos.infra.db.repository;

import com.fiap.gregory.seevideos.infra.db.model.Video;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VideoRepository extends ReactiveMongoRepository<Video, String> {

    Flux<Video> findAllOrderByPublicationDate();

}
