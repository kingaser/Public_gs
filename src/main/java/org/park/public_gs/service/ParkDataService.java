package org.park.public_gs.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.ParkDataDto;
import org.park.public_gs.dto.ParkInsertDto;
import org.park.public_gs.dto.ParkSearchDto;
import org.park.public_gs.dto.ParkStatusDto;
import org.park.public_gs.mapper.*;
import org.park.public_gs.vo.ParkDataVo;
import org.park.public_gs.vo.SpaceInfoVo;
import org.park.public_gs.vo.UserInfoVo;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkDataService {

    private final ParkDataHistoryMapper parkDataHistoryMapper;
    private final ParkDataMapper parkDataMapper;
    private final SerialMapper serialMapper;
    private final SpaceMapper spaceMapper;
    private final UserMapper userMapper;

    // 입차 정보
    public void parkInsert(HttpSession session, ParkInsertDto parkInsertDto, String ipAddress) {
        // 입차날짜 출차날짜 HTML 에 날짜와 시간으로 분리되어 있어서 합쳐주는 작업
        String enterDate = parkInsertDto.getEnterDate() + " " + parkInsertDto.getEnterHour() + ":" + parkInsertDto.getEnterMinute();
        String leaveDate = parkInsertDto.getOutDate() != "" ?
                parkInsertDto.getOutDate() + " " + parkInsertDto.getOutHour() + ":" + parkInsertDto.getOutMinute() : null;

        String insertUserId = String.valueOf(session.getAttribute("loginId"));

        Calendar calendar = Calendar.getInstance();
        int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);

        // user 정보 요원 이름으로 검색
        UserInfoVo enterUserInfo = userMapper.findByUserName(parkInsertDto.getEnterUser());
        UserInfoVo leaveUserInfo = userMapper.findByUserName(parkInsertDto.getLeaverUser());

        // 주차장 정보 주차장 명으로 검색
        SpaceInfoVo spaceInfo = spaceMapper.getSpaceInfo(parkInsertDto.getSpaceNm());

        // Serial Number
        String serialNo = serialMapper.getParkDataSeq();

        // ParkDataVo 객체 생성 후 저장
        ParkDataVo parkdataVo = ParkDataVo.builder()
                .serialNo(serialNo)
                .spaceNo(spaceInfo.getSpaceNo())
                .carNo(parkInsertDto.getCarNo())
                .enterDate(enterDate)
                .enterUser(enterUserInfo.getUserId())
                .discountCode(parkInsertDto.getDiscountCode())
                .leaveType(parkInsertDto.getLeaveType())
                .leaveDate(leaveDate)
                .leaveUser(leaveUserInfo != null ? leaveUserInfo.getUserId() : null)
                .spotCount(parkInsertDto.getSpotCount())
                .userRemark(parkInsertDto.getUserRemark())
                .spotNo(parkInsertDto.getSpotNo())
                .gasan(parkInsertDto.getGasan())
                .discAmount(parkInsertDto.getDiscAmount())
                .cutAmount(parkInsertDto.getCutAmount())
                .saleAmount(parkInsertDto.getSaleAmount())
                .receiveAmount(parkInsertDto.getReceiveAmount())
                .recpDt(parkInsertDto.getRecpDt() != "" ? parkInsertDto.getRecpDt() : null)
                .remark(parkInsertDto.getRemark())
                .insertUser(insertUserId)
                .insertIp(ipAddress)
                .accGubun(parkInsertDto.getAccGubun())
                .chasu(String.valueOf(dayOfWeekNumber))
                .gojiState(parkInsertDto.getGojiState())
                .build();

        parkDataMapper.parkDataInsert(parkdataVo);
        parkDataHistoryMapper.parkDataHistoryInsert(parkdataVo);
    }

    // 이용 현황 검색
    public List<ParkStatusDto> getParkDataSearchList(ParkSearchDto parkSearchDto) {
        return parkDataMapper.getParkDataSearchList(parkSearchDto);
    }

    // 이용 현황 선택 조회
    public ParkDataDto getParkDataDetail(String serialNo) {
        return parkDataMapper.getParkDataDetail(serialNo);
    }

    // 이용 현황 선택 수정
    public void updateParkData(String serialNo, ParkInsertDto parkInsertDto, HttpSession session, String ipAddress) {
        String enterDate = parkInsertDto.getEnterDate() + " " + parkInsertDto.getEnterHour() + ":" + parkInsertDto.getEnterMinute();
        String leaveDate = parkInsertDto.getOutDate() != "" ?
                parkInsertDto.getOutDate() + " " + parkInsertDto.getOutHour() + ":" + parkInsertDto.getOutMinute() : null;

        String updateUsername = String.valueOf(session.getAttribute("loginNm"));
        // user 정보 요원 이름으로 검색
        UserInfoVo leaveUserInfo = userMapper.findByUserName(parkInsertDto.getLeaverUser());
        UserInfoVo updateUserInfo = userMapper.findByUserName(updateUsername);

        // 주차장 정보 주차장 명으로 검색
        SpaceInfoVo spaceInfo = spaceMapper.getSpaceInfo(parkInsertDto.getSpaceNm());

        // ParkDataVo 객체 생성 후 저장
        ParkDataVo parkdataVo = ParkDataVo.builder()
                .serialNo(serialNo)
                .spaceNo(spaceInfo.getSpaceNo())
                .carNo(parkInsertDto.getCarNo())
                .enterDate(enterDate)
                .discountCode(parkInsertDto.getDiscountCode())
                .leaveType(parkInsertDto.getLeaveType())
                .leaveDate(leaveDate)
                .leaveUser(leaveUserInfo != null ? leaveUserInfo.getUserId() : "")
                .spotCount(parkInsertDto.getSpotCount())
                .userRemark(parkInsertDto.getUserRemark())
                .spotNo(parkInsertDto.getSpotNo())
                .gasan(parkInsertDto.getGasan())
                .discAmount(parkInsertDto.getDiscAmount())
                .cutAmount(parkInsertDto.getCutAmount())
                .saleAmount(parkInsertDto.getSaleAmount())
                .receiveAmount(parkInsertDto.getReceiveAmount())
                .recpDt(parkInsertDto.getRecpDt())
                .remark(parkInsertDto.getRemark())
                .accGubun(parkInsertDto.getAccGubun())
                .gojiState(parkInsertDto.getGojiState())
                .updateUser(updateUserInfo.getUserId())
                .updateIp(ipAddress)
                .build();

        parkDataMapper.updateParkData(parkdataVo);
        parkDataHistoryMapper.parkDataHistoryInsert(parkdataVo);
    }

    // 이용 현황 선택 삭제
    public void deleteParkData(String serialNo) {
        parkDataMapper.deleteParkData(serialNo);
        parkDataHistoryMapper.parkDataHistoryInsert(parkDataMapper.getParkData(serialNo));
    }
}
