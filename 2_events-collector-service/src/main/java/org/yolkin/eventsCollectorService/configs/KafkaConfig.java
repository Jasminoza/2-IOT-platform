package org.yolkin.eventsCollectorService.configs;


import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@Data
@EnableKafka
@ConfigurationProperties(prefix = "kafka")
public class KafkaConfig {

    private String bootstrapServers;
    private String schemaRegistryUrl;
    List<KafkaTopic> kafkaTopicList;

    @Data
    public static class KafkaTopic {
        private String name;
        private String groupId;
        private Integer partitionsCount;
        private Integer replicasCount;
    }
}
