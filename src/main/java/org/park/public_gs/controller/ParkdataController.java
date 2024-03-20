package org.park.public_gs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.service.ParkdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ParkdataController {

    private final ParkdataService parkdataService;

    // 이용 현황 페이지
    @GetMapping("/park/status")
    public String parkStatus(Model model) {
        List<ParkStatusDto> parkStatusList = parkdataService.getParkdataList();
        model.addAttribute("parkStatusList", parkStatusList);
        log.info("parkStatusList", parkStatusList);
        return "park/status";
    }

    @PostMapping("/park/insert")
    public String parkInsert() {
        return "/";
    }
}
