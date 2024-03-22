package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/*
* 이용현황 검색 DTO
* */
@Getter
public class ParkSearchDto {

    private String carNo;       // 차량번호
    private String spaceNm;     // 주차장명
    private String accGubun;    // 미수구분
    private Date enterDate;     // 입차날짜
    private Date outDate;       // 출차날짜

    @Builder
    public ParkSearchDto(String carNo, String spaceNm, String accGubun, Date enterDate, Date outDate) {
        this.carNo = carNo;
        this.spaceNm = spaceNm;
        this.accGubun = accGubun;
        this.enterDate = enterDate;
        this.outDate = outDate;
    }
}
