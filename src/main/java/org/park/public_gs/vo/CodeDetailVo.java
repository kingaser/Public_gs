package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Getter
@RequiredArgsConstructor
public class CodeDetailVo {

    private String commonCode;      // 분류 코드
    private String code;            // 세부 분류 코드
    private String codeName;        // 세부 분류명
    private Integer sortNum;        // 정렬코드
    private String useYN;           // 사용유무
    private String Remark;          // 비고(메모, 상담, 용도 등)
    private String Del_Tag;         // 상태구분(0 정상, 9 삭제 등)
    private String InsertUser;      // 입력자 ID
    private Date InsertDate;        // 입력일시
    private String UpdateUser;      // 수정자
    private Date UpdateDate;        // 수정일시

    @Builder
    public CodeDetailVo(String commonCode, String code, String codeName, Integer sortNum, String useYN, String Remark,
                        String Del_Tag, String InsertUser, Date InsertDate, String UpdateUser, Date UpdateDate) {
        this.commonCode = commonCode;
        this.code = code;
        this.codeName = codeName;
        this.sortNum = sortNum;
        this.useYN = useYN;
        this.Remark = Remark;
        this.Del_Tag = Del_Tag;
        this.InsertUser = InsertUser;
        this.InsertDate = InsertDate;
        this.UpdateUser = UpdateUser;
        this.UpdateDate = UpdateDate;
    }
}
