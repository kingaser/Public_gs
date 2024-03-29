package org.park.public_gs.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.MessageDto;
import org.park.public_gs.mapper.BankAccountMapper;
import org.park.public_gs.vo.BankAccountVo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountMapper bankAccountMapper;

    // 가상계좌 생성
    public MessageDto createBankAccount(String serialNo, HttpServletRequest request) {

        HashMap<String, String> bankParam = new HashMap<>() {{
            put("serialNo", serialNo);
            put("userId", String.valueOf(request.getSession().getAttribute("loginId")));
        }};

        if (checkBankAccount(serialNo)) {
            String account = bankAccountMapper.callAccount(bankParam);
            return MessageDto.builder()
                    .status(HttpStatus.OK.value())
                    .message(account + " 가상계좌 생성이 완료되었습니다.")
                    .build();
        } else {
            return MessageDto.builder()
                    .status(HttpStatus.CONFLICT.value())
                    .message("가상계좌가 이미 있습니다.")
                    .build();
        }
    }

    // 가상계좌 확인
    private boolean checkBankAccount(String serialNo) {

        Optional<BankAccountVo> bankAccountVo = bankAccountMapper.getBankAccount(serialNo);
        return bankAccountVo.isEmpty();
    }
}