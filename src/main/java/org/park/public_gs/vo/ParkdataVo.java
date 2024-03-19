package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Getter
@RequiredArgsConstructor
public class ParkdataVo {

    private String serialNo;        // 고유번호
    private String spaceNo;         // 주차장 코드
    private String carNo;           // 차량번호
    private String EnterType;       // 임차유형
    private Date EnterDate;         // 입차일시
    private String EnterUser;       // 입차요원
    private String DiscountCode;    // 할인코드
    private String LeaveType;       // 출차유형
    private Date LeaveDate;         // 출차일시
    private String LeaveUser;       // 출차요원
    private Integer SpotCount;      // 구획수
    private String UserRemark;      // 요원메모
    private String Certification;   // 즉시감면여부
    private Integer OrigAmount;     // 원금액
    private Integer CouponAmount;   // 쿠폰할인금액(선할인)
    private Integer DiscAmount;     // 할인금액(후할인)
    private Integer SaleAmount;     // 이용금액
    private Integer ReceiveAmount;  // 납부금액
    private Integer CutAmount;      // 절사금액
    private Integer FeeAmount;      // 수수료
    private Integer Gasan;          // 가산금액
    private String RecpNo;          // 연수번호
    private String SpotNo;          // 구획번호
    private String proceTag;        // 상태
    private String Remark;          // 관리자메모
    private String RecpUser;        // 수납요원
    private String RecpDt;          // 수납일
    private String RepSpaceNo;      // 수납주차장
    private String accGubun;        // 결제구분
    private String GojiState;       // 고지차수
    private String RefundRecpNo;    // 환불영수번호
    private String InsertUser;      // 입력자 ID
    private Date InsertDate;        // 입력일시
    private String InsertIP;        // 입력 IP
    private String UpdateUser;      // 수정자 ID
    private Date UpdateDate;        // 수정일시
    private String UpdateIP;        // 입력 IP
    private String Del_Tag;         // 삭제유무
    private String chasu;           // 차수(요일)

    @Builder
    public ParkdataVo(String serialNo, String spaceNo, String carNo, String EnterType, Date EnterDate, String EnterUser,
                      String DiscountCode, String LeaveType, Date LeaveDate, String LeaveUser, Integer SpotCount, String UserRemark,
                      String Certification, Integer OrigAmount, Integer CouponAmount, Integer DiscAmount, Integer SaleAmount,
                      Integer ReceiveAmount, Integer CutAmount, Integer FeeAmount, Integer Gasan, String RecpNo, String SpotNo,
                      String proceTag, String Remark, String RecpUser, String RecpDt, String RepSpaceNo, String accGubun,
                      String GojiState, String RefundRecpNo, String InsertUser, Date InsertDate, String InsertIP,
                      String UpdateUser, Date UpdateDate, String UpdateIP, String Del_Tag, String chasu) {
        this.serialNo = serialNo;
        this.spaceNo = spaceNo;
        this.carNo = carNo;
        this.EnterType = EnterType;
        this.EnterDate = EnterDate;
        this.EnterUser = EnterUser;
        this.DiscountCode = DiscountCode;
        this.LeaveType = LeaveType;
        this.LeaveDate = LeaveDate;
        this.LeaveUser = LeaveUser;
        this.SpotCount = SpotCount;
        this.UserRemark = UserRemark;
        this.Certification = Certification;
        this.OrigAmount = OrigAmount;
        this.CouponAmount = CouponAmount;
        this.DiscAmount = DiscAmount;
        this.SaleAmount = SaleAmount;
        this.ReceiveAmount = ReceiveAmount;
        this.CutAmount = CutAmount;
        this.FeeAmount = FeeAmount;
        this.Gasan = Gasan;
        this.RecpNo = RecpNo;
        this.SpotNo = SpotNo;
        this.proceTag = proceTag;
        this.Remark = Remark;
        this.RecpUser = RecpUser;
        this.RecpDt = RecpDt;
        this.RepSpaceNo = RepSpaceNo;
        this.accGubun = accGubun;
        this.GojiState = GojiState;
        this.RefundRecpNo = RefundRecpNo;
        this.InsertUser = InsertUser;
        this.InsertDate = InsertDate;
        this.InsertIP = InsertIP;
        this.UpdateUser = UpdateUser;
        this.UpdateDate = UpdateDate;
        this.UpdateIP = UpdateIP;
        this.Del_Tag = Del_Tag;
        this.chasu = chasu;
    }
}
