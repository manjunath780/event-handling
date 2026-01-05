package com.demo.event_handling.service;



import com.demo.event_handling.events.*;
import com.demo.event_handling.producer.ProducerOneService;
import com.demo.event_handling.producer.ProducerTwoService;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final ProducerOneService producerOne;
    private final ProducerTwoService producerTwo;

    public EventService(ProducerOneService producerOne,
                        ProducerTwoService producerTwo) {
        this.producerOne = producerOne;
        this.producerTwo = producerTwo;
    }

    public void publishEventType1(EventType1 input) {
        EventType1 event = new EventType1();
        event.setOrderId(input.getOrderId());
        event.setNoteText(input.getNoteText());
        event.setNoteReason(input.getNoteReason());
        event.setEntityType(input.getEntityType());

        producerOne.sendEvent1(event);
    }

    public void publishEventType3(EventType3 input) {
        EventType3 event = new EventType3();
        event.setOrderId(input.getOrderId());
        event.setCustomerName(input.getCustomerName());
        event.setOrderDate(input.getOrderDate());
        event.setEntityType(input.getEntityType());

        producerOne.sendEvent3(event);
    }

    public void publishEventType5(EventType5 input) {
        EventType5 event = new EventType5();
        event.setPaymentId(input.getPaymentId());
        event.setOrderId(input.getOrderId());
        event.setPaymentAmount(input.getPaymentAmount());
        event.setPaymentMethod(input.getPaymentMethod());
        event.setEntityType(input.getEntityType());

        producerOne.sendEvent5(event);
    }

    public void publishEventType2(EventType2 input) {
        EventType2 event = new EventType2();
        event.setShipmentId(input.getShipmentId());
        event.setOrderId(input.getOrderId());
        event.setNoteText(input.getNoteText());
        event.setEntityType(input.getEntityType());
        event.setEntityKey(input.getEntityKey());

        producerTwo.sendEvent2(event);
    }

    public void publishEventType4(EventType4 input) {
        EventType4 event = new EventType4();
        event.setShipmentId(input.getShipmentId());
        event.setOrderId(input.getOrderId());
        event.setShipmentDate(input.getShipmentDate());
        event.setEntityType(input.getEntityType());

        producerTwo.sendEvent4(event);
    }
}
