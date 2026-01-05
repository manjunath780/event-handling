package com.demo.event_handling.producer;

import com.demo.event_handling.events.EventType1;
import com.demo.event_handling.events.EventType3;
import com.demo.event_handling.events.EventType5;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerOneService {

    private final KafkaTemplate<String, String> template;
    private final ObjectMapper mapper;

    public ProducerOneService(KafkaTemplate<String, String> template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }


    public void sendEvent1(EventType1 event) {
        sendEvent(event, "EVENT_TYPE_1");
    }

    public void sendEvent3(EventType3 event) {
        sendEvent(event, "EVENT_TYPE_3");
    }

    public void sendEvent5(EventType5 event) {
        sendEvent(event, "EVENT_TYPE_5");
    }

    private void sendEvent(Object event, String eventType) {
        try {
            String payload = mapper.writeValueAsString(event);
            ProducerRecord<String, String> record = new ProducerRecord<>("multi-event-topic", payload);
            record.headers().add("eventType", eventType.getBytes());
            template.send(record);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // optionally log error or throw custom exception
        }
    }

}

