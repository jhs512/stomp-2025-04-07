package com.back.domain.chat.chatRoom.controller;

import com.back.domain.chat.chatRoom.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatRoomController {
    private final List<ChatRoom> chatRooms = new ArrayList<>() {{
        // 아래는 샘플데이터 생성코드 입니다.
        add(
                ChatRoom
                        .builder()
                        .id(1)
                        .createDate(LocalDateTime.now())
                        .modifyDate(LocalDateTime.now())
                        .name("풋살하실 분?")
                        .build()
        );

        add(
                ChatRoom
                        .builder()
                        .id(2)
                        .createDate(LocalDateTime.now())
                        .modifyDate(LocalDateTime.now())
                        .name("농구 하실 분?")
                        .build()
        );

        add(
                ChatRoom
                        .builder()
                        .id(3)
                        .createDate(LocalDateTime.now())
                        .modifyDate(LocalDateTime.now())
                        .name("야구 하실 분?")
                        .build()
        );
    }};

    @GetMapping
    public List<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    @GetMapping("/{id}")
    public ChatRoom getChatRoom(
            @PathVariable long id
    ) {
        Optional<ChatRoom> opChatRoom = findById(id);

        return opChatRoom.get();
    }


    @AllArgsConstructor
    @Getter
    public static class ChatCreateReqBody {
        private String name;
    }

    @PostMapping
    public ChatRoom createChatRoom(
            @RequestBody ChatCreateReqBody reqBody
    ) {
        ChatRoom chatRoom = ChatRoom
                .builder()
                .id(chatRooms.size() + 1)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .name(reqBody.name)
                .build();

        chatRooms.add(chatRoom);

        return chatRoom;
    }

    private Optional<ChatRoom> findById(long id) {
        return chatRooms.stream()
                .filter(chatRoom -> chatRoom.getId() == id)
                .findFirst();
    }
}
