package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

/*
* 이용현황 검색 DTO
* */
@Getter


public class ParkSearchDto {

    private String carNo;       // 차량번호
    private String spaceNo;     // 주차장명
    private String dateType;    // 날짜 기준 타입
    private String enterDate;   // 입차날짜
    private String leaveDate;   // 출차날짜
    private String proceTag;    // 미수구분

    @Builder
    public ParkSearchDto(String carNo, String spaceNo, String dateType, String proceTag, String enterDate, String leaveDate) {
        this.carNo = carNo;
        this.spaceNo = spaceNo;
        this.dateType = dateType;
        this.proceTag = proceTag;
        this.enterDate = enterDate;
        this.leaveDate = leaveDate;
    }
}
