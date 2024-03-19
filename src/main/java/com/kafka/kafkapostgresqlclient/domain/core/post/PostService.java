package com.kafka.kafkapostgresqlclient.domain.core.post;

import com.kafka.kafkapostgresqlclient.model.kafka.post.Post;

public interface PostService {
    void savePost(Post post);
}
