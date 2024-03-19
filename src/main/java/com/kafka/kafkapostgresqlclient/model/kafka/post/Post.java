package com.kafka.kafkapostgresqlclient.model.kafka.post;

import java.util.Date;

public record Post(
        String title,
        String body,
        Date postedAt
) {
}
