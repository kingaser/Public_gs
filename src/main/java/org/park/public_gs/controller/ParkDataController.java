package org.park.public_gs.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.ParkDataDto;
import org.park.public_gs.dto.ParkInsertDto;
import org.park.public_gs.dto.ParkSearchDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.service.ParkDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ParkDataController {

    private final ParkDataService parkdataService;

    // 이용 현황 페이지
    @GetMapping("/park/status")
    public String parkStatus() {
        return "park/status";
    }

    // 입차 정보
    @PostMapping("/park/insert")
    public String parkInsert(HttpServletRequest request, ParkInsertDto parkInsertDto) {
        String ipAddress = request.getRemoteAddr();
        parkdataService.parkInsert(request.getSession(), parkInsertDto, ipAddress);
        return "redirect:/park/status";
    }

    // 이용 현황 검색
    @GetMapping("/park/search")
    @ResponseBody
    public List<ParkStatusDto> parkSearch(@RequestParam("carNo") String carNo,
                                          @RequestParam("spaceNo") String spaceNo,
                                          @RequestParam("dateType") String dateType,
                                          @RequestParam("enterDate") String enterDate,
                                          @RequestParam("leaveDate") String leaveDate,
                                          @RequestParam("proceTag") String proceTag,
                                          Model model) {
        ParkSearchDto parkSearchDto = ParkSearchDto.builder()
                .carNo(carNo)
                .spaceNo(spaceNo)
                .dateType(dateType)
                .enterDate(enterDate)
                .leaveDate(leaveDate)
                .proceTag(proceTag)
                .build();
        List<ParkStatusDto> parkStatusList = parkdataService.getParkDataSearchList(parkSearchDto);
        model.addAttribute("parkStatusList", parkStatusList);
        log.info("parkStatusList", parkStatusList);
        return parkStatusList;
    }

    // 선택한 데이터 상세
    @GetMapping("/park/status/{serialNo}")
    @ResponseBody
    public ParkDataDto parkStatusDetail(@PathVariable("serialNo") String serialNo) {
        return parkdataService.getParkDataDetail(serialNo);
    }

    // 선택한 데이터 삭제
    @DeleteMapping("/park/status/delete/{serialNo}")
    public String parkDataDelete(@PathVariable("serialNo") String serialNo) {
        parkdataService.deleteParkData(serialNo);
        return "redirect:/park/status";
    }
}
