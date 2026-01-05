package com.demo.event_handling.listener;

import com.demo.event_handling.handler.EventDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOneListener {

    private final EventDispatcher dispatcher;

    public ConsumerOneListener(EventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @KafkaListener(topics = "multi-event-topic", groupId = "group-1")
    public void listen(ConsumerRecord<String, String> record) {
        String type = new String(record.headers()
                .lastHeader("eventType").value());
        dispatcher.dispatch(type, record.value());
    }
}
