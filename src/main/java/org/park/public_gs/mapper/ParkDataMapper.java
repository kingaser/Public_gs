package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.dto.ParkDataDto;
import org.park.public_gs.dto.ParkSearchDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.vo.ParkDataVo;

import java.util.List;

@Mapper
public interface ParkDataMapper {

    void parkDataInsert(ParkDataVo parkdataVo);

    List<ParkStatusDto> getParkDataSearchList(ParkSearchDto parkSearchDto);

    ParkDataDto getParkDataDetail(String serialNo);

    void deleteParkData(String serialNo);

    void updateParkData(ParkDataVo parkDataVo);
}
