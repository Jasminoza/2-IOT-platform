package org.yolkin.eventsCollectorService.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.yolkin.avroschemas.DeviceEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeviceEventKafkaListener {

    private static final String TOPIC = "DeviceEvents";
    private static final String GROUP_ID = "device-events-collector-group";

    @KafkaListener(
        topics = TOPIC,
        groupId = GROUP_ID
    )
    public void listenRawEvents(DeviceEvent deviceEvent) {
        log.info("New device event has been arrived: {}", deviceEvent);
    }
}
