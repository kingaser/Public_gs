package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.dto.ParkStatusDto;

import java.util.List;

@Mapper
public interface ParkdataMapper {
    List<ParkStatusDto> getParkdataList();
}
