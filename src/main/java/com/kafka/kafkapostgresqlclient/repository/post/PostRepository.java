package com.kafka.kafkapostgresqlclient.repository.post;

import com.kafka.kafkapostgresqlclient.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
