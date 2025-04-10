package com.back.global;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleStompMessageTemplate implements StompMessageTemplate {
    private final SimpMessagingTemplate template;

    @Override
    public void convertAndSend(String type, String destination, Object payload) {
        template.convertAndSend("/" + type + "/" + destination, payload);
    }
}