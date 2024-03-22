package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ParkHistoryVo {

    private String serialNo;                // 고유번호
    private Integer spaceNo;                // 주차장 코드
    private String carNo;                   // 차량번호
    private String enterType;               // 임차유형
    private Date enterDate;                 // 입차일시
    private String enterUser;               // 입차요원
    private String discountCode;            // 할인코드
    private String leaveType;               // 출차유형
    private Date leaveDate;                 // 출차일시
    private String leaveUser;               // 출차요원
    private Integer spotCount;              // 구획수 / 사용구획(수)
    private String userRemark;              // 요원메모
    private String certification;           // 즉시감면여부
    private Integer origAmount;             // 원금액
    private Integer couponAmount;           // 쿠폰할인금액(선할인)
    private Integer discAmount;             // 할인금액(후할인)
    private Integer saleAmount;             // 이용금액
    private Integer receiveAmount;          // 납부금액
    private Integer cutAmount;              // 절사금액
    private Integer feeAmount;              // 수수료
    private Integer gasan;                  // 가산금액
    private String recpNo;                  // 영수번호
    private Integer spotNo;                 // 구획번호
    private String proceTag;                // 상태
    private String remark;                  // 관리자메모
    private String recpUser;                // 수납요원
    private String recpDt;                  // 수납일
    private Integer repSpaceNo;             // 수납주차장
    private String accGubun;                // 결제구분
    private String gojiState;               // 고지차수
    private String refundRecpNo;            // 환불영수번호
    private String insertUser;              // 입력자 ID
    private Date insertDate;                // 입력일시
    private String insertIp;                // 입력 IP
    private String updateUser;              // 수정자 ID
    private Date updateDate;                // 수정일시
    private String updateIp;                // 입력 IP
    private String del_Tag;                 // 삭제유무
    private String chasu;                   // 차수(요일)
    private String parkGroup;

    @Builder
    public ParkHistoryVo(String serialNo, Integer spaceNo, String carNo, String enterType, Date enterDate, String enterUser,
                      String discountCode, String leaveType, Date leaveDate, String leaveUser, Integer spotCount,
                      String userRemark, String certification, Integer origAmount, Integer couponAmount,
                      Integer discAmount, Integer saleAmount, Integer receiveAmount, Integer cutAmount,
                      Integer feeAmount, Integer gasan, String recpNo, Integer spotNo, String proceTag, String remark,
                      String recpUser, String recpDt, Integer repSpaceNo, String accGubun, String gojiState,
                      String refundRecpNo, String insertUser, Date insertDate, String insertIp, String updateUser,
                      Date updateDate, String updateIp, String del_Tag, String chasu, String parkGroup) {
        this.serialNo = serialNo;
        this.spaceNo = spaceNo;
        this.carNo = carNo;
        this.enterType = enterType;
        this.enterDate = enterDate;
        this.enterUser = enterUser;
        this.discountCode = discountCode;
        this.leaveType = leaveType;
        this.leaveDate = leaveDate;
        this.leaveUser = leaveUser;
        this.spotCount = spotCount;
        this.userRemark = userRemark;
        this.certification = certification;
        this.origAmount = origAmount;
        this.couponAmount = couponAmount;
        this.discAmount = discAmount;
        this.saleAmount = saleAmount;
        this.receiveAmount = receiveAmount;
        this.cutAmount = cutAmount;
        this.feeAmount = feeAmount;
        this.gasan = gasan;
        this.recpNo = recpNo;
        this.spotNo = spotNo;
        this.proceTag = proceTag;
        this.remark = remark;
        this.recpUser = recpUser;
        this.recpDt = recpDt;
        this.repSpaceNo = repSpaceNo;
        this.accGubun = accGubun;
        this.gojiState = gojiState;
        this.refundRecpNo = refundRecpNo;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.insertIp = insertIp;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
        this.updateIp = updateIp;
        this.del_Tag = del_Tag;
        this.chasu = chasu;
        this.parkGroup = parkGroup;
    }


}
