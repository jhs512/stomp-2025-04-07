package com.back.domain.chat.chatMessage.controller;

import com.back.domain.chat.chatMessage.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/chat/rooms/{chatRoomId}/messages")
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatMessageController {
    private int lastChatMessageId = 0;
    private final Map<Integer, List<ChatMessage>> chatMessagesByRoomId = new HashMap<>() {{
        put(1, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(1)
                            .writerName("김철수")
                            .content("풋살하실 분 계신가요?")
                            .build()
            );

            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(1)
                            .writerName("이영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
        put(2, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(2)
                            .writerName("박철수")
                            .content("농구하실 분 계신가요?")
                            .build()
            );

            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(2)
                            .writerName("김영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
        put(3, new ArrayList<>() {{
            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(3)
                            .writerName("이철수")
                            .content("야구하실 분 계신가요?")
                            .build()
            );

            add(
                    ChatMessage
                            .builder()
                            .id(++lastChatMessageId)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .chatRoomId(3)
                            .writerName("박영희")
                            .content("네, 저요!")
                            .build()
            );
        }});
    }};

    @GetMapping
    public List<ChatMessage> getChatMessages(
            @PathVariable int chatRoomId,
            @RequestParam(defaultValue = "-1") int afterChatMessageId
    ) {
        List<ChatMessage> chatMessages = chatMessagesByRoomId.getOrDefault(chatRoomId, List.of());

        if (afterChatMessageId == -1) {
            return chatMessages;
        }

        return chatMessages.stream()
                .filter(chatMessage -> chatMessage.getId() > afterChatMessageId)
                .toList();
    }


    @AllArgsConstructor
    @Getter
    public static class ChatMessageWriteReqBody {
        private String writerName;
        private String content;
    }

    @PostMapping
    public ChatMessage writeChatMessage(
            @PathVariable int chatRoomId,
            @RequestBody ChatMessageWriteReqBody reqBody
    ) {
        return writeChatMessage(chatRoomId, reqBody.writerName, reqBody.content);
    }

    private ChatMessage writeChatMessage(
            int chatRoomId,
            String writerName,
            String content
    ) {
        List<ChatMessage> chatMessages = chatMessagesByRoomId.get(chatRoomId);

        if (chatMessages == null) {
            chatMessages = new ArrayList<>();
            chatMessagesByRoomId.put(chatRoomId, chatMessages);
        }

        ChatMessage chatMessage = ChatMessage
                .builder()
                .id(++lastChatMessageId)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .chatRoomId(chatRoomId)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessages.add(chatMessage);

        return chatMessage;
    }
}
