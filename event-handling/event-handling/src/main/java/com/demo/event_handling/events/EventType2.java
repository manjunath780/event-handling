package com.demo.event_handling.events;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("SHIPMENT_NOTE_UPDATED")
public class EventType2 implements BaseMessage {

    @JsonProperty("shipmentId")
    private String shipmentId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("noteText")
    private String noteText;

    @JsonProperty("entityType")
    @Builder.Default
    private String entityType = "SHIPMENT";

    @JsonProperty("entityKey")
    private String entityKey;
}


