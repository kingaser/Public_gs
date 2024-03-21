package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class CodeDetailVo {

    private String commonCode;              // 분류 코드
    private String code;                    // 세부 분류 코드
    private String codeName;                // 세부 분류명
    private Integer sortNum;                // 정렬코드
    private String useYN;                   // 사용유무
    private String remark;                  // 비고(메모, 상담, 용도 등)
    private String del_Tag;                 // 상태구분(0 정상, 9 삭제 등)
    private String insertUser;              // 입력자 ID
    private Date insertDate;                // 입력일시
    private String updateUser;              // 수정자
    private Date updateDate;                // 수정일시

    @Builder
    public CodeDetailVo(String commonCode, String code, String codeName, Integer sortNum, String useYN, String remark,
                        String del_Tag, String insertUser, Date insertDate, String updateUser, Date updateDate) {
        this.commonCode = commonCode;
        this.code = code;
        this.codeName = codeName;
        this.sortNum = sortNum;
        this.useYN = useYN;
        this.remark = remark;
        this.del_Tag = del_Tag;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }
}
