package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CodeMasterVo {

    private Integer seq;
    private String commonCode;      // 공통 코드
    private String commonName;      // 동통 코드명
    private String Remark;          // 비고(메모, 상담, 용도등)
    private String del_Tag;         // 사용유무

    @Builder
    public CodeMasterVo(Integer seq, String commonCode, String commonName, String Remark, String del_Tag) {
        this.seq = seq;
        this.commonCode = commonCode;
        this.commonName = commonName;
        this.Remark = Remark;
        this.del_Tag = del_Tag;
    }
}
