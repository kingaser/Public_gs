package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

/*
* 이용현황 조회
* */
@Getter
public class ParkStatusDto {

    private String spaceNm;         // 주차장명
    private String enterDate;         // 입차일시
    private String leaveDate;         // 출차일시
    private String carNo;           // 차량번호
    private String recpNo;          // 영수번호
    private String accGubun;        // 결제구분
    private Integer saleAmount;     // 이용금액
    private Integer discAmount;     // 할인금액(후할인)
    private Integer gasan;          // 가산금액

    @Builder
    public ParkStatusDto(String spaceNm, String enterDate, String leaveDate, String carNo, String recpNo,
                         String accGubun, Integer saleAmount, Integer discAmount, Integer gasan) {

        this.spaceNm = spaceNm;
        this.enterDate = enterDate;
        this.leaveDate = leaveDate;
        this.carNo = carNo;
        this.recpNo = recpNo;
        this.accGubun = accGubun;
        this.saleAmount = saleAmount;
        this.discAmount = discAmount;
        this.gasan = gasan;
    }
}
