package org.park.public_gs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.service.CodeService;
import org.park.public_gs.vo.CodeDetailVo;
import org.park.public_gs.vo.CodeMasterVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    // 주차장 코드 리스트
    @GetMapping("/code/codeManage")
    public String getCodeMasterList(Model model) {
        List<CodeMasterVo> codeMasterList = codeService.getCodeMasterList();
        model.addAttribute("masterList", codeMasterList);
        log.info("codeMasterList : " + codeMasterList);
        return "code/codeManage";
    }

    @GetMapping("/code/codeDetail")
    @ResponseBody
    public List<CodeDetailVo> getCodeDetailList(@RequestParam("commonCode") String commonCode, Model model) {
        List<CodeDetailVo> codeDetailList = codeService.getCodeDetailList(commonCode);
        model.addAttribute("detailList", codeDetailList);
        log.info("codeDetailList : " + codeDetailList);
        return codeDetailList;
    }
}
