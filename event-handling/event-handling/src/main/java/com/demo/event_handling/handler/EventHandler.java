package com.demo.event_handling.handler;

import com.demo.event_handling.events.*;
import org.springframework.stereotype.Component;

@Component
public class EventHandler{

    @KafkaEventHandler("EVENT_TYPE_1")
    public void handle1(EventType1 e) {
        System.out.println("Consumer1 → EVENT_TYPE_1");
    }

    @KafkaEventHandler("EVENT_TYPE_3")
    public void handle3(EventType3 e) {
        System.out.println("Consumer1 → EVENT_TYPE_3");
    }

    @KafkaEventHandler("EVENT_TYPE_5")
    public void handle5(EventType5 e) {
        System.out.println("Consumer1 → EVENT_TYPE_5");
    }

    @KafkaEventHandler("EVENT_TYPE_2")
    public void handle2( EventType2 e) {
        System.out.println("Consumer2 → EVENT_TYPE_3");
    }

    @KafkaEventHandler("EVENT_TYPE_4")
    public void handle4(EventType4 e) {
        System.out.println("Consumer2 → EVENT_TYPE_4");
    }
}
