package org.example.azure.storeage.queue.controller;


import com.azure.core.http.rest.Response;
import com.azure.spring.integration.storage.queue.StorageQueueTemplate;
import com.azure.spring.integration.storage.queue.factory.StorageQueueClientFactory;
import com.azure.storage.queue.QueueAsyncClient;
import com.azure.storage.queue.models.SendMessageResult;
import org.example.azure.storeage.queue.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class SendController {

    @Autowired
    private StorageQueueTemplate queueTemplate;
    @Autowired
    private StorageQueueClientFactory storageQueueClientFactory;


    @PostMapping("/messages")
    public String postMessage(@RequestParam String parameter) {

        MessageHeaderAccessor accessor = new MessageHeaderAccessor();
        accessor.setHeader("foo", "bar");
        MessageHeaders headers = accessor.getMessageHeaders();
        Message<User> message = MessageBuilder.createMessage(new User(parameter), headers);
        queueTemplate.sendAsync("storeagequeue",message);
        return parameter;
    }
}
