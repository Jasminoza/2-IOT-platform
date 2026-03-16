package org.yolkin.eventsCollectorService.configs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(
    KafkaConfig.class
)
public class ApplicationConfig {

}
