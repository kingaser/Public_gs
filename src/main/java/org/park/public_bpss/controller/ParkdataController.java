package org.park.public_bpss.controller;

import org.park.public_bpss.service.ParkdataService;
import org.park.public_bpss.vo.ParkdataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParkdataController {
  @Autowired
  private ParkdataService parkdataService;


  @GetMapping("/park/parkdata")
  public String getParkdata(Model model){
    return "/park/parkdata";
  }

  @PostMapping("/parkdata/parkdataInsert")
  public String getParkdataInsert(ParkdataVo parkdataVo){
    parkdataService.parkdataInsert(parkdataVo);
    return "redirect:/parkdataList";
  }

}
