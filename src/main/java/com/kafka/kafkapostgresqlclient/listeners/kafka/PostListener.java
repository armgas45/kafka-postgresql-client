package com.kafka.kafkapostgresqlclient.listeners.kafka;

import com.kafka.kafkapostgresqlclient.domain.core.post.PostService;
import com.kafka.kafkapostgresqlclient.model.kafka.post.Post;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostListener {
    private final PostService postService;

    @KafkaListener(topics = "PostsTopic", groupId = "posts")
    public void savePosts(@Payload Post post) {
        postService.savePost(post);
    }
}
