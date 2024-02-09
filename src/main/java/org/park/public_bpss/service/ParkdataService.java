package org.park.public_bpss.service;

import org.park.public_bpss.mapper.ParkdataMapper;
import org.park.public_bpss.vo.ParkdataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkdataService {

  @Autowired
  private ParkdataMapper parkdataMapper;

  public void parkdataInsert(ParkdataVo parkdataVo){
    parkdataMapper.parkdataInsert(parkdataVo);
  }
  //public List<userInfoVo> getparkdataList(){    return userMapper.getUserInfoList();  }
  //public userInfoVo userInfoSelect(Integer userNo){    return userMapper.userInfoSelect(userNo);  }
  //public userInfoVo userLogin(userInfoVo userInfo){    return userMapper.findByLoginId(userInfo);  }
}
