package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.dto.ParkDataDto;
import org.park.public_gs.dto.ParkSearchDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.vo.ParkDataVo;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkDataMapper {

    void parkDataInsert(ParkDataVo parkdataVo);

    List<ParkStatusDto> getParkDataSearchList(ParkSearchDto parkSearchDto);

    ParkDataDto getParkDataDetail(String serialNo);

    void deleteParkData(Map<String, String> map);

    void updateParkData(ParkDataVo parkDataVo);

    ParkDataVo getParkData(String serialNo);

    void updateParkPayCancel(Map<String, String> paramMap);
}
