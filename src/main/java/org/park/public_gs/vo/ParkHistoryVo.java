package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ParkHistoryVo {

    private String serialNo;
    private Integer spaceNo;
    private String carNo;
    private String enterType;
    private Date enterDate;
    private String enterUser;
    private String discountCode;
    private String leaveType;
    private Date leaveDate;
    private String leaveUser;
    private Integer spotCount;
    private String userRemark;
    private String certification;
    private Integer origAmount;
    private Integer couponAmount;
    private Integer discAmount;
    private Integer saleAmount;
    private Integer receiveAmount;
    private Integer cutAmount;
    private Integer feeAmount;
    private Integer gasan;
    private String recpNo;
    private Integer spotNo;
    private String proceTag;
    private String remark;
    private String recpUser;
    private Date recpDt;
    private Integer repSpaceNo;
    private String accGubun;
    private String gojiState;
    private String refundRecpNo;
    private String insertUser;
    private Date insertDate;
    private String insertIp;
    private String updateUser;
    private Date updateDate;
    private String updateIp;
    private String del_Tag;
    private String chasu;
    private String parkGroup;

    @Builder
    public ParkHistoryVo(String serialNo, Integer spaceNo, String carNo, String enterType, Date enterDate,
                         String enterUser, String discountCode, String leaveType, Date leaveDate, String leaveUser,
                         Integer spotCount, String userRemark, String certification, Integer origAmount,
                         Integer couponAmount, Integer discAmount, Integer saleAmount, Integer receiveAmount,
                         Integer cutAmount, Integer feeAmount, Integer gasan, String recpNo, Integer spotNo,
                         String proceTag, String remark, String recpUser, Date recpDt, Integer repSpaceNo,
                         String accGubun, String gojiState, String refundRecpNo, String insertUser, Date insertDate,
                         String insertIp, String updateUser, Date updateDate, String updateIp,
                         String del_Tag, String chasu, String parkGroup) {
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
