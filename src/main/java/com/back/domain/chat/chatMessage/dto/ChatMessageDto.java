package com.back.domain.chat.chatMessage.dto;

import com.back.domain.chat.chatMessage.entity.ChatMessage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class ChatMessageDto {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private long chatRoomId;
    private String writerName;
    private String content;

    public ChatMessageDto(ChatMessage message) {
        this.id = message.getId();
        this.createDate = message.getCreateDate();
        this.modifyDate = message.getModifyDate();
        this.chatRoomId = message.getChatRoomId();
        this.writerName = message.getWriterName();
        this.content = message.getContent();
    }
}