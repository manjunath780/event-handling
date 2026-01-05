package com.demo.event_handling.controller;

import com.demo.event_handling.events.*;
import com.demo.event_handling.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/event1")
    public String sendEvent1(@RequestBody EventType1 event) {
        eventService.publishEventType1(event);
        return "EVENT_TYPE_1 sent!";
    }

    @PostMapping("/event3")
    public String sendEvent3(@RequestBody EventType3 event) {
        eventService.publishEventType3(event);
        return "EVENT_TYPE_3 sent!";
    }

    @PostMapping("/event5")
    public String sendEvent5(@RequestBody EventType5 event) {
        eventService.publishEventType5(event);
        return "EVENT_TYPE_5 sent!";
    }

    @PostMapping("/event2")
    public String sendEvent2(@RequestBody EventType2 event) {
        eventService.publishEventType2(event);
        return "EVENT_TYPE_2 sent!";
    }

    @PostMapping("/event4")
    public String sendEvent4(@RequestBody EventType4 event) {
        eventService.publishEventType4(event);
        return "EVENT_TYPE_4 sent!";
    }
}
