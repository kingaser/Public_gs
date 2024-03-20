package org.park.public_gs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.mapper.CodeMapper;
import org.park.public_gs.vo.CodeDetailVo;
import org.park.public_gs.vo.CodeMasterVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeMapper codeMapper;

    public List<CodeMasterVo> getCodeMasterList() {
        return codeMapper.codeMasterList();
    }

    public List<CodeDetailVo> getCodeDetailList(String commonCode) {
        log.info("SELECT * FROM code_detail WHERE commonCode = ", commonCode);
        return codeMapper.codeDetailList(commonCode);
    }
}
