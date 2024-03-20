package org.park.public_gs.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ParkStatusDto {

    private String spaceNm;         // 주차장명
    private Date EnterDate;         // 입차일시
    private Date LeaveDate;         // 출차일시
    private String carNo;           // 차량번호
    private String RecpNo;          // 영수번호
    private String accGubun;        // 결제구분
    private Integer SaleAmount;     // 이용금액
    private Integer DiscAmount;     // 할인금액(후할인)
    private Integer Gasan;          // 가산금액

    @Builder
    public ParkStatusDto(String spaceNm, Date EnterDate, Date LeaveDate, String carNo, String RecpNo, String accGubun,
                         Integer SaleAmount, Integer DiscAmount, Integer Gasan) {
        this.spaceNm = spaceNm;
        this.EnterDate = EnterDate;
        this.LeaveDate = LeaveDate;
        this.carNo = carNo;
        this.RecpNo = RecpNo;
        this.accGubun = accGubun;
        this.SaleAmount = SaleAmount;
        this.DiscAmount = DiscAmount;
        this.Gasan = Gasan;
    }
}
