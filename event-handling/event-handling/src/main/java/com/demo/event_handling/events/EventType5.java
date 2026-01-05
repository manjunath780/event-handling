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
@JsonTypeName("PAYMENT_PROCESSED")
public class EventType5 implements BaseMessage {

    @JsonProperty("paymentId")
    private String paymentId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("paymentAmount")
    private Double paymentAmount;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("entityType")
    @Builder.Default
    private String entityType = "PAYMENT";
}
