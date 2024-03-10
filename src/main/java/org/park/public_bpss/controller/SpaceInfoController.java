package org.park.public_bpss.controller;

import lombok.extern.slf4j.Slf4j;
import org.park.public_bpss.service.SpaceInfoService;
import org.park.public_bpss.vo.SpaceInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class SpaceInfoController {
  @Autowired
  private SpaceInfoService spaceInfoService;

  @GetMapping("/space/spaceInfoList")
  public String getSpaceInfoList(Model model){
    List<SpaceInfoVo> spaceInfoList = spaceInfoService.getSpaceInfoList();
    model.addAttribute("list", spaceInfoList);
    log.info("spaceInfoList : "+spaceInfoList.toString());
    return "/space/spaceInfoList";
  }

  @GetMapping("/space/spaceInfo")
  public String getSpaceInfo(Model model){
    return "/space/spaceInfo";
  }

  @PostMapping("/space/spaceInfoInsert")
  public String getSpaceInfoInsert(SpaceInfoVo spaceInfoVo){
    spaceInfoService.spaceInfoInsert(spaceInfoVo);
    return "redirect:/spaceInfoList";
  }

  @GetMapping("/space/spaceInfoView")
  public String spaceInfoView(Model model, Integer spaceNo){
    model.addAttribute("view", spaceInfoService.spaceInfoSelect(spaceNo));
    return "/space/spaceInfoView";
  }

}
