package org.park.public_gs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.ParkInsertDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.mapper.ParkDataMapper;
import org.park.public_gs.mapper.SpaceMapper;
import org.park.public_gs.vo.ParkDataVo;
import org.park.public_gs.vo.SpaceInfoVo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkDataService {

    private final ParkDataMapper parkDataMapper;
    private final SpaceMapper spaceMapper;

    public List<ParkStatusDto> getParkdataList() {
        return parkDataMapper.getParkDataList();
    }

    public void parkInsert(ParkInsertDto parkInsertDto) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date enterDate = null;

        try {
            enterDate = (Date) format.parse(parkInsertDto.getEnterDate() + " " + parkInsertDto.getEnterHour() + " " + parkInsertDto.getEnterMinute());
        } catch (ParseException e) {
            log.error(e.getMessage());
        }

        SpaceInfoVo spaceInfo = spaceMapper.getSpaceInfo(parkInsertDto.getSpaceNm()).orElseThrow(
                () -> new NullPointerException("404, 해당 추자장이 없습니다.")
        );

        ParkDataVo parkdataVo = ParkDataVo.builder()
                .spaceNo(spaceInfo.getSpaceNo())
                .enterDate(enterDate)
                .enterUser(parkInsertDto.getEnterUser())
                .carNo(parkInsertDto.getCarNo())
                .spotCount(parkInsertDto.getSpotCount())
                .spotNo(parkInsertDto.getSpotNo())
                .recpNo(parkInsertDto.getRectNo())
                .gasan(parkInsertDto.getGasan())
                .remark(parkInsertDto.getRemark())
                .receiveAmount(parkInsertDto.getReceiveAmount())
                .build();
        parkDataMapper.parkDataInsert(parkdataVo);
    }
}
