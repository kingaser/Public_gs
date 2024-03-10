package org.park.public_bpss.service;

import org.park.public_bpss.mapper.UserMapper;
import org.park.public_bpss.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

  @Autowired
  private UserMapper userMapper;

  public List<UserInfoVo> getUserInfoList(){
    return userMapper.getUserInfoList();
  }
  public void userInfoInsert(UserInfoVo userInfoVo){
    userMapper.userInfoInsert(userInfoVo);
  }
  public UserInfoVo userInfoSelect(Integer userNo){
    return userMapper.userInfoSelect(userNo);
  }

  public UserInfoVo userLogin(UserInfoVo userInfo){
    return userMapper.findByLoginId(userInfo);
  }
}
