package org.park.public_mlink.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_mlink.vo.CommonCodeVo;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

  List<CommonCodeVo> CommonCodeSpaceInfo();
  List<CommonCodeVo> CommonCodeUserList();
  List<CommonCodeVo> CommonCodeDiscList();

}
