package org.park.public_gs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.ParkInsertDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.service.ParkDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ParkDataController {

    private final ParkDataService parkdataService;

    // 이용 현황 페이지
    @GetMapping("/park/status")
    public String parkStatus(Model model) {
        List<ParkStatusDto> parkStatusList = parkdataService.getParkdataList();
        model.addAttribute("parkStatusList", parkStatusList);
        log.info("parkStatusList", parkStatusList);
        return "park/status";
    }

    // 입차 정보
    @PostMapping("/park/insert")
    public String parkInsert(ParkInsertDto parkInsertDto) {
        parkdataService.parkInsert(parkInsertDto);
        return "redirect:park/status";
    }

}
