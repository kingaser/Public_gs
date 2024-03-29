package org.park.public_gs.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.park.public_gs.dto.MessageDto;
import org.park.public_gs.service.BankAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/bank/create")
    public MessageDto bankAccountCreate(@RequestBody String serialNo,
                                        HttpServletRequest request) {
        log.info("serialNo = " + serialNo);
        return bankAccountService.createBankAccount(serialNo, request);
    }

}
