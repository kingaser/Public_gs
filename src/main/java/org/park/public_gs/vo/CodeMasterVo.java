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
    private String remark;          // 비고(메모, 상담, 용도등)
    private String del_Tag;         // 사용유무

    @Builder
    public CodeMasterVo(Integer seq, String commonCode, String commonName, String remark, String del_Tag) {
        this.seq = seq;
        this.commonCode = commonCode;
        this.commonName = commonName;
        this.remark = remark;
        this.del_Tag = del_Tag;
    }
}
