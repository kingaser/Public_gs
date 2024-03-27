package org.park.public_gs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.mapper.CommonCodeMapper;
import org.park.public_gs.vo.CommonCodeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeMapper commonCodeMapper;

    /**
     * 공통 데이터
     *
     * @return
     */
    public List<CommonCodeVo> getCommonCodeSpaceList() {
        return commonCodeMapper.commonCodeSpaceInfo();
    }

    public List<CommonCodeVo> getCommonCodeUserList() {
        return commonCodeMapper.commonCodeUserList();
    }

    public List<CommonCodeVo> getCommonCodeDiscList() {
        return commonCodeMapper.commonCodeDiscList();
    }

    public List<CommonCodeVo> getCommonCodeAccInfoList() {
        return commonCodeMapper.commonCodeAccInfoList();
    }

    public List<CommonCodeVo> getCommonCodeLeave() {
        return commonCodeMapper.commonCodeLeave();
    }

    public List<CommonCodeVo> getCommonCodeMisu() {
        return commonCodeMapper.commonCodeMisu();
    }

    public List<CommonCodeVo> getCommonCodeSearchDateType() {
        return commonCodeMapper.commonCodeSearchDateType();
    }
}
