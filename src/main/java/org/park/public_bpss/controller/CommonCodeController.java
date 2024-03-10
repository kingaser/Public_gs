package org.park.public_bpss.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_bpss.service.CommonCodeService;
import org.park.public_bpss.vo.CommonCodeVo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CommonCodeController {

  private final CommonCodeService commonCodeService;
  @GetMapping(value = "/common/spaceInfoList")
  public List<CommonCodeVo> getCommonCodeSpaceList(){
    List<CommonCodeVo> CommonCodeList = commonCodeService.getCommonCodeSpaceList();
    log.info("common_spaceInfoList : "+CommonCodeList);
    return CommonCodeList;
  }

  @GetMapping(value = "/common/userInfoList")
  public List<CommonCodeVo> getCommonCodeUserList(){
    List<CommonCodeVo> CommonCodeUserList = commonCodeService.getCommonCodeUserList();
    log.info("common_userInfoList : "+CommonCodeUserList);
    return CommonCodeUserList;
  }

  @GetMapping(value = "/common/discInfoList")
  public List<CommonCodeVo> getCommonCodeDiscList(){
    List<CommonCodeVo> CommonCodeDiscList = commonCodeService.getCommonCodeDiscList();
    log.info("common_discInfoList : "+CommonCodeDiscList);
    return CommonCodeDiscList;
  }

}
