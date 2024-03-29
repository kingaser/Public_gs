package org.park.public_gs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.park.public_gs.vo.BankAccountVo;

import java.util.HashMap;
import java.util.Optional;

@Mapper
public interface BankAccountMapper {

    String callAccount(HashMap<String, String> bankParam);

    Optional<BankAccountVo> getBankAccount(String serialNo);
}
