package org.yolkin.eventsCollectorService.configs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

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
        private String containerFactory;
        private Integer partitionsCount;
        private Integer replicasCount;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }
}
