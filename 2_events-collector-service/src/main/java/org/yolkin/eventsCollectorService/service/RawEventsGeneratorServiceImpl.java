package org.yolkin.eventsCollectorService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RawEventsGeneratorServiceImpl implements RawEventsGeneratorService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void generateSameEvents(int count) {
        System.out.println("Generate same events with " + count + " events");
        for (int i = 0; i < count; i++) {
            kafkaTemplate.send("RawEvents", "Отправляю Эвент");
        }
    }
}
