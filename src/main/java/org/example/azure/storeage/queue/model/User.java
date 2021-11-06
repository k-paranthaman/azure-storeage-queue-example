package org.example.azure.storeage.queue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
}
