package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.CommonCodeVo;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    List<CommonCodeVo> commonCodeSpaceInfo();

    List<CommonCodeVo> commonCodeUserList();

    List<CommonCodeVo> commonCodeDiscList();

    List<CommonCodeVo> commonCodeAccInfoList();

    List<CommonCodeVo> commonCodeLeave();

}
