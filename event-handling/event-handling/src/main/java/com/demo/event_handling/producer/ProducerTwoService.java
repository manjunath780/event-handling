package com.demo.event_handling.producer;

import com.demo.event_handling.events.EventType2;
import com.demo.event_handling.events.EventType4;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerTwoService {

    private final KafkaTemplate<String, String> template;
    private final ObjectMapper mapper;

    public ProducerTwoService(KafkaTemplate<String, String> template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendEvent2(EventType2 event) {
        sendEvent(event, "EVENT_TYPE_2");
    }

    public void sendEvent4(EventType4 event) {
        sendEvent(event, "EVENT_TYPE_4");
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

