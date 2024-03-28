package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/*
 * 이용현황 조회
 * */
@Getter
public class ParkStatusDto {

    private String serialNo;
    private String spaceNm;         // 주차장명
    private String enterDate;       // 입차일시
    private String leaveDate;       // 출차일시
    private String carNo;           // 차량번호
    private String recpDt;          // 영수번호
    private String accGubun;        // 결제구분(코드)
    private String accName;         // 결제구분(이름)
    private Integer origAmount;     // 원금액
    private Integer saleAmount;     // 이용금액
    private Integer discAmount;     // 할인금액(후할인)
    private Integer receiveAmount;  // 할인금액(후할인)
    private Integer gasan;          // 가산금액

    @Builder
    public ParkStatusDto(String serialNo, String spaceNm, String enterDate, String leaveDate, String carNo,
                         String recpDt, String accName, String accGubun, Integer origAmount, Integer saleAmount,
                         Integer discAmount, Integer receiveAmount, Integer gasan) {
        this.serialNo = serialNo;
        this.spaceNm = spaceNm;
        this.enterDate = enterDate;
        this.leaveDate = leaveDate;
        this.carNo = carNo;
        this.recpDt = recpDt;
        this.accGubun = accGubun;
        this.accName = accName;
        this.origAmount = origAmount;
        this.saleAmount = saleAmount;
        this.discAmount = discAmount;
        this.receiveAmount = receiveAmount;
        this.gasan = gasan;
    }
}
