package com.back.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // HTML을 템플릿으로 렌더링할 때 사용
@RequestMapping("/chat/rooms") // 공통 URL prefix
public class ChatRoomController {

    @GetMapping("/{chatRoomId}") // /chat/rooms/{chatRoomId} 요청을 처리
    public String getChatRoom(
            @PathVariable String chatRoomId // 경로 변수 바인딩
    ) {
        // chatRoomId는 필요에 따라 모델에 담거나 로그로 남길 수 있음
        return "chat/chatRoom"; // templates/chat/chatRoom.html 로 매핑됨
    }
}