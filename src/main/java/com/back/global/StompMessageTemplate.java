package com.back.global;

public interface StompMessageTemplate {
    void convertAndSend(String type, String destination, Object payload);
}