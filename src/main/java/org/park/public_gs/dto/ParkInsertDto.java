package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ParkInsertDto {

    private String enterDate;       // 입차 날짜
    private String enterHour;       // 입차 시간(시)
    private String enterMinute;     // 입차 시간(분)
    private String EnterUser;       // 입차 요원
    private String spaceNm;         // 주차장명
    private String carNo;           // 차량번호
    private Integer SpotCount;      // 구획수 / 사용구획(수)
    private String SpotNo;          // 구획번호
    private String discountCode;    // 할인 코드
    private String outDate;         // 출차 날짜
    private String outHour;         // 출차 시간(시)
    private String outMinute;       // 출차 시간(분)
    private String LeaverUser;      // 출차 요원
    private String LeaveType;       // 출차 유형
    private String RectNo;          // 영수 번호
    private Integer Gasan;          // 가산금액
    private Integer CutAmount;      // 절사요금
    private Integer SaleAmount;     // 이용금액
    private Integer ReceiveAmount;  // 납부금액
    private String cardAmount;      // 카드
    private String cashAmount;      // 현금
    private String discountAmount;  // 할인 금액
    private String Remark;          // 메모

    @Builder
    public ParkInsertDto(String enterDate, String enterHour, String enterMinute, String EnterUser, String spaceNm,
                         String carNo, Integer SpotCount, String SpotNo, String discountCode, String outDate,
                         String outHour, String outMinute, String LeaverUser, String LeaveType, String RectNo,
                         Integer Gasan, Integer CutAmount, Integer SaleAmount, Integer ReceiveAmount, String cardAmount,
                         String cashAmount, String discountAmount, String Remark) {
        this.enterDate = enterDate;
        this.enterHour = enterHour;
        this.enterMinute = enterMinute;
        this.EnterUser = EnterUser;
        this.spaceNm = spaceNm;
        this.carNo = carNo;
        this.SpotCount = SpotCount;
        this.SpotNo = SpotNo;
        this.discountCode = discountCode;
        this.outDate = outDate;
        this.outHour = outHour;
        this.outMinute = outMinute;
        this.LeaverUser = LeaverUser;
        this.LeaveType = LeaveType;
        this.RectNo = RectNo;
        this.Gasan = Gasan;
        this.CutAmount = CutAmount;
        this.SaleAmount = SaleAmount;
        this.ReceiveAmount = ReceiveAmount;
        this.cardAmount = cardAmount;
        this.cashAmount = cashAmount;
        this.discountAmount = discountAmount;
        this.Remark = Remark;
    }
}
