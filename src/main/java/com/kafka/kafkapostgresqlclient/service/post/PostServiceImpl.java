package com.kafka.kafkapostgresqlclient.service.post;

import com.kafka.kafkapostgresqlclient.domain.core.post.PostService;
import com.kafka.kafkapostgresqlclient.mapper.post.PostMapper;
import com.kafka.kafkapostgresqlclient.model.kafka.post.Post;
import com.kafka.kafkapostgresqlclient.repository.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void savePost(Post post) {
        if (post == null) throw new IllegalArgumentException();

        var postEntity = postMapper.toPostEntity(post);

        postRepository.save(postEntity);
    }
}
