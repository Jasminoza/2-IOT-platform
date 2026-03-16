package org.yolkin.eventsCollectorService.listeners;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;
import org.yolkin.eventsCollectorService.configs.KafkaConfig;
import org.yolkin.eventsCollectorService.configs.KafkaConfig.KafkaTopic;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaInitializer {

    private final KafkaConfig kafkaConfig;
    private final KafkaAdmin kafkaAdmin;

    @PostConstruct
    public void init() {
        log.info("Initializing Kafka topics...");
        List<KafkaTopic> topics = kafkaConfig.getKafkaTopicList();
        NewTopic[] topicsForCreation = topics.stream()
            .map(topic -> TopicBuilder
                .name(topic.getName())
                .partitions(topic.getPartitionsCount())
                .replicas(topic.getReplicasCount())
                .build()
            )
            .toArray(NewTopic[]::new);
        log.info("Creating topics {}.", Arrays.toString(topicsForCreation));
        kafkaAdmin.createOrModifyTopics(topicsForCreation);
        log.info("Topics has been successfully created.");
    }
}
