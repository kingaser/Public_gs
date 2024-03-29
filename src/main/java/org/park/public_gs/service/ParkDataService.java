package org.park.public_gs.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.*;
import org.park.public_gs.mapper.*;
import org.park.public_gs.vo.ParkDataVo;
import org.park.public_gs.vo.SpaceInfoVo;
import org.park.public_gs.vo.UserInfoVo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void parkInsert(HttpServletRequest request, ParkInsertDto parkInsertDto) {

        Map<String, String> dateMap = enterAndLeaveDate(parkInsertDto);
        Map<String, String> userMap = userAndIp(request);

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
                .enterDate(dateMap.get("enterDate"))
                .enterUser(enterUserInfo.getUserId())
                .discountCode(parkInsertDto.getDiscountCode())
                .leaveType(parkInsertDto.getLeaveType())
                .leaveDate(dateMap.get("leaveDate"))
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
                .insertUser(userMap.get("userId"))
                .insertIp(userMap.get("ipAddress"))
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
    public void updateParkData(String serialNo, ParkInsertDto parkInsertDto, HttpServletRequest request) {

        Map<String, String> dateMap = enterAndLeaveDate(parkInsertDto);
        Map<String, String> userMap = userAndIp(request);

        // user 정보 요원 이름으로 검색
        UserInfoVo leaveUserInfo = userMapper.findByUserName(parkInsertDto.getLeaverUser());

        // 주차장 정보 주차장 명으로 검색
        SpaceInfoVo spaceInfo = spaceMapper.getSpaceInfo(parkInsertDto.getSpaceNm());

        // ParkDataVo 객체 생성 후 저장
        ParkDataVo parkdataVo = ParkDataVo.builder()
                .serialNo(serialNo)
                .spaceNo(spaceInfo.getSpaceNo())
                .carNo(parkInsertDto.getCarNo())
                .enterDate(dateMap.get("enterDate"))
                .discountCode(parkInsertDto.getDiscountCode())
                .leaveType(parkInsertDto.getLeaveType())
                .leaveDate(dateMap.get("leaveDate"))
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
                .updateUser(userMap.get("userId"))
                .updateIp(userMap.get("ipAddress"))
                .build();

        parkDataMapper.updateParkData(parkdataVo);
        parkDataHistoryMapper.parkDataHistoryInsert(parkdataVo);
    }

    // 이용 현황 선택 삭제
    public void deleteParkData(HttpServletRequest request, String serialNo) {
        Map<String, String> userAndId = userAndIp(request);
        userAndId.put("serialNo", serialNo);
        parkDataMapper.deleteParkData(userAndId);
        parkDataHistoryMapper.parkDataHistoryInsert(parkDataMapper.getParkData(serialNo));
    }

    // 결제 미완성
    public void updateParkPay(HttpServletRequest request, ParkInsertDto parkInsertDto) {

        Map<String, String> dateMap = enterAndLeaveDate(parkInsertDto);
        Map<String, String> userMap = userAndIp(request);

        UserInfoVo leaveUserInfo = userMapper.findByUserName(parkInsertDto.getLeaverUser());

        ParkDataVo parkDataVo = ParkDataVo.builder()
                .discountCode(parkInsertDto.getDiscountCode())
                .leaveDate(dateMap.get("leaveDate"))
                .leaveUser(leaveUserInfo.getUserId())
                .updateIp(userMap.get("ipAddress"))
                .updateUser(userMap.get("userId"))
                .build();
    }

    // 결제 취소
    public MessageDto cancelParkPay(String serialNo, HttpServletRequest request) {
        Map<String, String> paramMap = userAndIp(request);
        paramMap.put("serialNo", serialNo);

        ParkDataVo parkData = parkDataMapper.getParkData(serialNo);

        if (parkData.getAccGubun().equals("00") || parkData.getProceTag().equals("0")) {
            return MessageDto.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("결제가 되어있지 않습니다.")
                    .build();
        }

        parkDataMapper.updateParkPayCancel(paramMap);

        return MessageDto.builder()
                .status(HttpStatus.OK.value())
                .message("결제 취소 완료")
                .build();
    }

    // IP 주소, 로그인한 userId 추출 메서드
    private Map<String, String> userAndIp(HttpServletRequest request) {
        String userId = String.valueOf(request.getSession().getAttribute("loginId"));
        String ipAddress = request.getRemoteAddr();

        Map<String, String> userAndIp = new HashMap<>() {{
            put("userId", userId);
            put("ipAddress", ipAddress);
        }};

        return userAndIp;
    }

    // 입차날짜 출차날짜 계산 메서드
    private Map<String, String> enterAndLeaveDate(ParkInsertDto parkInsertDto) {
        String enterDate = parkInsertDto.getEnterDate() + " " + parkInsertDto.getEnterHour() + ":" + parkInsertDto.getEnterMinute();
        String leaveDate = parkInsertDto.getOutDate() != "" ?
                parkInsertDto.getOutDate() + " " + parkInsertDto.getOutHour() + ":" + parkInsertDto.getOutMinute() : null;

        Map<String, String> dateMap = new HashMap<>() {{
            put("enterDate", enterDate);
            put("leaveDate", leaveDate);
        }};

        return dateMap;
    }
}
