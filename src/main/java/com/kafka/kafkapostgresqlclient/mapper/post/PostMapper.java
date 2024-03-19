package com.kafka.kafkapostgresqlclient.mapper.post;

import com.kafka.kafkapostgresqlclient.entity.post.PostEntity;
import com.kafka.kafkapostgresqlclient.model.kafka.post.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostEntity toPostEntity(Post post) {
        if (post == null) return null;

        return PostEntity.builder()
                .title(post.title())
                .body(post.body())
                .postedAt(post.postedAt())
                .build();
    }
}
