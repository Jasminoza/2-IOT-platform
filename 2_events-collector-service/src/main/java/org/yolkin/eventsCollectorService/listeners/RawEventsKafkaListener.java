package org.yolkin.eventsCollectorService.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RawEventsKafkaListener {

    @KafkaListener(
        topics = "RawEvents",
        groupId = "events-collector-group"
    )
    public void listenRawEvents(String message) {
        System.out.println("New raw event: " + message);
    }
}
