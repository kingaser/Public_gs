package org.park.public_bpss.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_bpss.vo.ParkdataVo;

@Mapper
public interface ParkdataMapper {
  void parkdataInsert(ParkdataVo parkdataVo);
//  List<userInfoVo> getUserInfoList();
//  userInfoVo userInfoSelect(Integer userNo);
//  userInfoVo findByLoginId(userInfoVo userInfo);

}
