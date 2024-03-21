package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.UserInfoVo;

import java.util.List;

@Mapper
public interface UserMapper {
    void userInfoInsert(UserInfoVo userInfoVo);

    List<UserInfoVo> getUserInfoList();

    UserInfoVo userInfoSelect(Integer userNo);

    UserInfoVo findByLoginId(String userId);

}
