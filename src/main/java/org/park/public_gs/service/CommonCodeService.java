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
   * @return
   */
  public List<CommonCodeVo> getCommonCodeSpaceList(){
    return commonCodeMapper.CommonCodeSpaceInfo();
  }
  public List<CommonCodeVo> getCommonCodeUserList(){
    return commonCodeMapper.CommonCodeUserList();
  }
  public List<CommonCodeVo> getCommonCodeDiscList(){
    return commonCodeMapper.CommonCodeDiscList();
  }
}
