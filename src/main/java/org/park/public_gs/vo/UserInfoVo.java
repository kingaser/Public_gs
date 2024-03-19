package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserInfoVo {

    private Integer seq;
    private String userId;
    private String userNm;
    private String teamId;
    private String teamNm;
    private String partId;
    private String partNm;
    private String use_YN;
    private String userPw;
    private Integer spaceNo;
    private String userTel;
    private String remark;
    private String grade;

    @Builder
    public UserInfoVo(Integer seq, String userId, String userNm, String teamId, String teamNm,
                      String partId, String partNm, String use_YN, String userPw, Integer spaceNo,
                      String userTel, String remark, String grade) {
        this.seq = seq;
        this.userId = userId;
        this.userNm = userNm;
        this.teamId = teamId;
        this.teamNm = teamNm;
        this.partId = partId;
        this.partNm = partNm;
        this.use_YN = use_YN;
        this.userPw = userPw;
        this.spaceNo = spaceNo;
        this.userTel = userTel;
        this.remark = remark;
        this.grade = grade;
    }
}
