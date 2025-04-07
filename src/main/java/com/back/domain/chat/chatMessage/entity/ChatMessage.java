package com.back.domain.chat.chatMessage.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private long chatRoomId;
    private String writerName;
    private String content;
}
