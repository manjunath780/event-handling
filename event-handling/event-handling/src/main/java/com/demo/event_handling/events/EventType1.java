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
@JsonTypeName("ORDER_NOTE_CREATED")
public class EventType1 implements BaseMessage {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("noteText")
    private String noteText;

    @JsonProperty("noteReason")
    private String noteReason;

    @JsonProperty("entityType")
    @Builder.Default
    private String entityType = "ORDER";
}
