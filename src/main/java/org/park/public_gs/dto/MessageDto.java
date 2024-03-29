package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {


    private int status;     // 상태 코드
    private String message; // 메시지

    @Builder
    public MessageDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
