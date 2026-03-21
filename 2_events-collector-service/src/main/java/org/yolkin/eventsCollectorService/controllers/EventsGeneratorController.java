package org.yolkin.eventsCollectorService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yolkin.eventsCollectorService.service.EventsGeneratorService;

@RestController
@RequestMapping("/generate-events")
@RequiredArgsConstructor
public class EventsGeneratorController {

    private final EventsGeneratorService eventsGeneratorService;

    @PostMapping("/device-events/{count}")
    public void generateEmployees(@PathVariable(value = "count") Integer count) {
        eventsGeneratorService.generateDeviceEvents(count);
    }

}
