package org.park.public_gs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/*
 * 이용현황 신규 저장용 DTO
 * */
@Getter
public class ParkInsertDto {

    private String serialNo;
    private String spaceNm;             // 주차장명
    private Integer spotNo;             // 구획번호
    private String carNo;               // 차량번호
    private String enterDate;           // 입차 날짜
    private String enterHour;           // 입차 시간(시)
    private String enterMinute;         // 입차 시간(분)
    private String enterUser;           // 입차 요원
    private String discountCode;        // 할인 코드
    private String leaveType;           // 출차 유형
    private String outDate;             // 출차 날짜
    private String outHour;             // 출차 시간(시)
    private String outMinute;           // 출차 시간(분)
    private String leaverUser;          // 출차 요원
    private Integer spotCount;          // 구획수 / 사용구획(수)
    private String userRemark;          // 요원 메모
    private Integer gasan;              // 가산금액
    private Integer discAmount;         // 할인 금액
    private Integer cutAmount;          // 절사요금
    private Integer saleAmount;         // 이용금액
    private Integer receiveAmount;      // 납부금액
    private String recpNo;              // 영수 번호
    private String recpDt;                // 수납일 결제일
    private String remark;              // 메모
    private String accGubun;            // 결제구분
    private String gojiState;           // 고지상태(차수)

    @Builder
    public ParkInsertDto(String serialNo, String spaceNm, Integer spotNo, String carNo, String enterDate, String enterHour,
                         String enterMinute, String enterUser, String discountCode, String leaveType, String outDate,
                         String outHour, String outMinute, String leaverUser, Integer spotCount, String userRemark,
                         Integer gasan, Integer discAmount, Integer cutAmount, Integer saleAmount, Integer receiveAmount,
                         String recpNo, String recpDt, String remark, String accGubun, String gojiState) {
        this.serialNo = serialNo;
        this.spaceNm = spaceNm;
        this.spotNo = spotNo;
        this.carNo = carNo;
        this.enterDate = enterDate;
        this.enterHour = enterHour;
        this.enterMinute = enterMinute;
        this.enterUser = enterUser;
        this.discountCode = discountCode;
        this.leaveType = leaveType;
        this.outDate = outDate;
        this.outHour = outHour;
        this.outMinute = outMinute;
        this.leaverUser = leaverUser;
        this.spotCount = spotCount;
        this.userRemark = userRemark;
        this.gasan = gasan;
        this.discAmount = discAmount;
        this.cutAmount = cutAmount;
        this.saleAmount = saleAmount;
        this.receiveAmount = receiveAmount;
        this.recpNo = recpNo;
        this.recpDt = recpDt;
        this.remark = remark;
        this.accGubun = accGubun;
        this.gojiState = gojiState;
    }
}
