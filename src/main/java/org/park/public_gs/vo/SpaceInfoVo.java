package org.park.public_gs.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SpaceInfoVo {

    private Integer spaceNo;
    private String spaceNm;
    private Integer spaceSize;
    private Integer monthSpace;
    private String spaceMngType;
    private String address;
    private String user;
    private String ip;

    @Builder
    public SpaceInfoVo(Integer spaceNo, String spaceNm, Integer spaceSize, Integer monthSpace,
                       String spaceMngType, String address, String user, String ip) {
        this.spaceNo = spaceNo;
        this.spaceNm = spaceNm;
        this.spaceSize = spaceSize;
        this.monthSpace = monthSpace;
        this.spaceMngType = spaceMngType;
        this.address = address;
        this.user = user;
        this.ip = ip;
    }
}
