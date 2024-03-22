package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.ParkDataVo;

@Mapper
public interface ParkDataHistoryMapper {
    void parkDataHistoryInsert(ParkDataVo parkDataVo);
}
