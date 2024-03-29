package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {

    private int status;
    private String message;

    @Builder
    public MessageDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
