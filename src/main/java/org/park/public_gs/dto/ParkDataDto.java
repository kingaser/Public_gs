package org.park.public_gs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/*
* 이용현황 신규 저장용 DTO
* */
@Getter
public class ParkDataDto {

    private String serialNo;
    private String spaceNm;             // 주차장명
    private Integer spotNo;             // 구획번호
    private String carNo;               // 차량번호

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:ss:mm", timezone = "Asia/Seoul")  // 날짜 포맷 변경
    private Date enterDate;             // 날짜 포맷 입차 날짜
    private String enterUser;           // 입차 요원 ID
    private String discountCode;        // 할인 코드
    private String leaveType;           // 출차 유형

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:ss:mm", timezone = "Asia/Seoul")  // 날짜 포맷 변경
    private Date leaveDate;             // 날짜 포맷 출차 날짜
    private String leaverUser;          // 출차 요원 ID
    private Integer spotCount;          // 구획수 / 사용구획(수)
    private String userRemark;          // 요원 메모
    private Integer gasan;              // 가산금액
    private Integer origAmount;         // 원금액
    private Integer discAmount;         // 할인 금액
    private Integer cutAmount;          // 절사요금
    private Integer saleAmount;         // 이용금액
    private Integer receiveAmount;      // 납부금액
    private String recpNo;              // 영수 번호

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:ss:mm", timezone = "Asia/Seoul")  // 날짜 포맷 변경
    private Date recpDt;                // 수납일 결제일
    private String remark;              // 메모
    private String accGubun;            // 결제구분
    private String gojiState;           // 고지 상태(차수)
    private String proceTag;            // 0미납/1완납/9미납취소(서손처리)
    private String payDate;             // 가상계좌 입금 마감일
    private String account;             // 가상계좌번호

    @Builder
    public ParkDataDto(String serialNo, String spaceNm, Integer spotNo, String carNo, Date enterDate, String enterUser,
                       String discountCode, String leaveType, Date leaveDate, String leaverUser, Integer spotCount,
                       String userRemark, Integer gasan, Integer origAmount, Integer discAmount, Integer cutAmount,
                       Integer saleAmount, Integer receiveAmount, String recpNo, Date recpDt, String remark,
                       String accGubun, String gojiState, String proceTag, String payDate, String account) {
        this.serialNo = serialNo;
        this.spaceNm = spaceNm;
        this.spotNo = spotNo;
        this.carNo = carNo;
        this.enterDate = enterDate;
        this.enterUser = enterUser;
        this.discountCode = discountCode;
        this.leaveType = leaveType;
        this.leaveDate = leaveDate;
        this.leaverUser = leaverUser;
        this.spotCount = spotCount;
        this.userRemark = userRemark;
        this.gasan = gasan;
        this.origAmount = origAmount;
        this.discAmount = discAmount;
        this.cutAmount = cutAmount;
        this.saleAmount = saleAmount;
        this.receiveAmount = receiveAmount;
        this.recpNo = recpNo;
        this.recpDt = recpDt;
        this.remark = remark;
        this.accGubun = accGubun;
        this.gojiState = gojiState;
        this.proceTag = proceTag;
        this.payDate = payDate;
        this.account = account;
    }
}
