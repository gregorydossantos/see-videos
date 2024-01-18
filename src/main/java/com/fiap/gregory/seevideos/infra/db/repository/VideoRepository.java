package com.fiap.gregory.seevideos.infra.db.repository;

import com.fiap.gregory.seevideos.infra.db.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Long, Video> {
}
