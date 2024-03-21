package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommonCodeVo {
    private String codeNo;
    private String codeNm;

    @Builder
    public CommonCodeVo(String codeNo, String codeNm) {
        this.codeNo = codeNo;
        this.codeNm = codeNm;
    }
}
