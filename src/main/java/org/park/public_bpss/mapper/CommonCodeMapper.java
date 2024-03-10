package org.park.public_bpss.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_bpss.vo.CommonCodeVo;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

  List<CommonCodeVo> CommonCodeSpaceInfo();
  List<CommonCodeVo> CommonCodeUserList();
  List<CommonCodeVo> CommonCodeDiscList();

}
