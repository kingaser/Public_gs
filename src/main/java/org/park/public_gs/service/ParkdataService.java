package org.park.public_gs.service;

import lombok.RequiredArgsConstructor;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.mapper.ParkdataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkdataService {

    private final ParkdataMapper parkdataMapper;

    public List<ParkStatusDto> getParkdataList() {
        return parkdataMapper.getParkdataList();
    }
}
