package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BankAccountVo {

    private String bank;            // 은행
    private String bankCode;        // 은행 코드
    private String parkingType;     // 주차유형(시간, 월정기...)
    private String gubun;           // 그룹결제구분
    private String carNo;           // 차량 번호
    private String recpNo;          // 영수 번호
    private String gojiNo;          // 고지 번호
    private String spaceNo;         // 주차장 번호
    private String serialNo;        // 고유 번호
    private String account;         // 가상계좌번호
    private String receiveAmount;   // 입금금액
    private String payDate;         // 입금 마감일
    private String ipgmDt;          // 입금일
    private String ipgmTag;         // 입금 상태
    private String jm_SeqNo;        // 가상계좌 입금 채번
    private String insertUser;      // 등록자
    private String insertDate;      // 등록일
    private String updateUser;      // 수정자
    private String updateDate;      // 수정일
    private String memNm;           // 입금자명

    @Builder
    public BankAccountVo(String bank, String bankCode, String parkingType, String gubun, String carNo, String recpNo,
                         String gojiNo, String spaceNo, String serialNo, String account, String receiveAmount,
                         String payDate, String ipgmDt, String ipgmTag, String jm_SeqNo, String insertUser,
                         String insertDate, String updateUser, String updateDate, String memNm) {
        this.bank = bank;
        this.bankCode = bankCode;
        this.parkingType = parkingType;
        this.gubun = gubun;
        this.carNo = carNo;
        this.recpNo = recpNo;
        this.gojiNo = gojiNo;
        this.spaceNo = spaceNo;
        this.serialNo = serialNo;
        this.account = account;
        this.receiveAmount = receiveAmount;
        this.payDate = payDate;
        this.ipgmDt = ipgmDt;
        this.ipgmTag = ipgmTag;
        this.jm_SeqNo = jm_SeqNo;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
        this.memNm = memNm;
    }
}
