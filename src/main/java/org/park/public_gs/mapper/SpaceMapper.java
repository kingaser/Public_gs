package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.SpaceInfoVo;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SpaceMapper {
    List<SpaceInfoVo> getSpaceInfoList();

    void spaceInfoInsert(SpaceInfoVo spaceInfoVo);

    SpaceInfoVo spaceInfoSelect(Integer spaceNo);

    SpaceInfoVo getSpaceInfo(String spaceNm);
}
