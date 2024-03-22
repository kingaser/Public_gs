package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.dto.ParkSearchDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.vo.ParkDataVo;

import java.util.List;

@Mapper
public interface ParkDataMapper {
    List<ParkStatusDto> getParkDataList();

    void parkDataInsert(ParkDataVo parkdataVo);

    List<ParkStatusDto> getParkDataSearchList(ParkSearchDto parkSearchDto);

}
