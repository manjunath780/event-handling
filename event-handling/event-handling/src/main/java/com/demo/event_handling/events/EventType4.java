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
@JsonTypeName("SHIPMENT_CREATED")
public class EventType4 implements BaseMessage {

    @JsonProperty("shipmentId")
    private String shipmentId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("shipmentDate")
    private String shipmentDate;

    @JsonProperty("entityType")
    @Builder.Default
    private String entityType = "SHIPMENT";
}
