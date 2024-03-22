package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SerialMapper {

    String getParkDataSeq();
    String getBillSeq();
    String getJeonpyoSeq();
    String getMonthTermSeq();
}
