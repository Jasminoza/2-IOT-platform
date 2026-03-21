package org.yolkin.eventsCollectorService.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.yolkin.avroschemas.DeviceEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventsGeneratorServiceImpl implements EventsGeneratorService {

    private static final String TOPIC = "DeviceEvents";

    private final KafkaTemplate<String, DeviceEvent> producer;

    @Override
    public void generateDeviceEvents(int count) {
        log.info("Generating {} device events", count);
        for (int i = 0; i < count; i++) {
            int currentCount = i + 1;
            DeviceEvent event = new DeviceEvent();
            event.setEventId("Event id " + currentCount);
            event.setDeviceId("Device id " + currentCount);
            event.setType("Device type " + currentCount);
            event.setTimestamp(System.currentTimeMillis());
            event.setPayload("Payload " + currentCount);
            log.warn("Generated device event {}", event);
            producer.send(TOPIC, event);
        }
        log.info("{} device events has been successfully created", count);
    }
}
