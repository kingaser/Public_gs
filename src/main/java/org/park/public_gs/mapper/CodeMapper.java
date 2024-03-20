package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.CodeDetailVo;
import org.park.public_gs.vo.CodeMasterVo;

import java.util.List;

@Mapper
public interface CodeMapper {
    List<CodeMasterVo> codeMasterList();

    List<CodeDetailVo> codeDetailList(String commonCode);
}
