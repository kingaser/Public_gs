package org.park.public_gs.service;

import lombok.RequiredArgsConstructor;
import org.park.public_gs.mapper.SpaceMapper;
import org.park.public_gs.vo.SpaceInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceInfoService {

    private final SpaceMapper spaceMapper;

    public List<SpaceInfoVo> getSpaceInfoList() {
        return spaceMapper.getSpaceInfoList();
    }

    public void spaceInfoInsert(SpaceInfoVo spaceInfoVo) {
        spaceMapper.spaceInfoInsert(spaceInfoVo);
    }

    public SpaceInfoVo spaceInfoSelect(Integer spaceNo) {
        return spaceMapper.spaceInfoSelect(spaceNo);
    }


}
