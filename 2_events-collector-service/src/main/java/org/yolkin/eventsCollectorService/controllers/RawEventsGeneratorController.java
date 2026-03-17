package org.yolkin.eventsCollectorService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yolkin.eventsCollectorService.service.RawEventsGeneratorService;

@RestController
@RequestMapping("/raw-events")
@RequiredArgsConstructor
public class RawEventsGeneratorController {

    private final RawEventsGeneratorService rawEventsGeneratorService;

    @PostMapping("/generate/same/{count}")
    public void generateSameEvents(@PathVariable(value = "count") Integer count) {
        rawEventsGeneratorService.generateSameEvents(count);
    }
}
