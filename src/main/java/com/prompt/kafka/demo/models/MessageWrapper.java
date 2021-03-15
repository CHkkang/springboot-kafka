package com.prompt.kafka.demo.models;

import lombok.*;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MessageWrapper implements Serializable {
    private static final long serialVersionUID = 2121211L;

    private long timestamp;
    private String callerModule;
    private MessageType messageType;
    private String payload;
}
