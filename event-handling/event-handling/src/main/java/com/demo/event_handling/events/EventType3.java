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
@JsonTypeName("ORDER_CREATED")
public class EventType3 implements BaseMessage {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("entityType")
    @Builder.Default
    private String entityType = "ORDER";
}
