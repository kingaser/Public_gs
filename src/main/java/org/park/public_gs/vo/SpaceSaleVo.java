package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SpaceSaleVo {

    private String spaceNo;              // 주차장코드
    private String spaceNm;              // 주차장명
    private Integer freeTime;            // 최초무료시간
    private Integer outFreeTime;         // 종료시무료시간
    private Integer basicUnit;           // 기본시간
    private Integer basicPay;            // 기본요금
    private Integer intervalUnit;        // 분단위
    private Integer intervalPay;         // 분단위금액
    private Integer dayMaxPay;           // 일일최대요금
    private Integer dayMinPay;           // 최소요금
    private Integer monthPay;            // 월정기요금
    private String insertUser;           // 입력자ID
    private LocalDateTime insertDate;    // 입력일시
    private String updateUser;           // 수정자
    private LocalDateTime updateDate;    // 수정일시
    private String del_Tag;              // 상태구분 (0정상, 9삭제등)

    @Builder
    public SpaceSaleVo(String spaceNo, String spaceNm, Integer freeTime, Integer outFreeTime, Integer basicUnit,
                       Integer basicPay, Integer intervalUnit, Integer intervalPay, Integer dayMaxPay,
                       Integer dayMinPay, Integer monthPay, String insertUser, LocalDateTime insertDate,
                       String updateUser, LocalDateTime updateDate, String del_Tag) {
        this.spaceNo = spaceNo;
        this.spaceNm = spaceNm;
        this.freeTime = freeTime;
        this.outFreeTime = outFreeTime;
        this.basicUnit = basicUnit;
        this.basicPay = basicPay;
        this.intervalUnit = intervalUnit;
        this.intervalPay = intervalPay;
        this.dayMaxPay = dayMaxPay;
        this.dayMinPay = dayMinPay;
        this.monthPay = monthPay;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
        this.del_Tag = del_Tag;
    }
}
