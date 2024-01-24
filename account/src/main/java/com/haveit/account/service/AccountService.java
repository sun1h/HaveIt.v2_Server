package com.haveit.account.service;

import com.haveit.account.dto.request.SignupRequestDto;
import com.haveit.account.entity.Account;
import com.haveit.account.enums.AccountType;
import com.haveit.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountRepository accountRepository;
    public Account signup(SignupRequestDto signupRequestDto){
        //이미 존재할 경우 예외 처리

        //새 계정 생성
        Account account = Account.builder()
                .email(signupRequestDto.getEmail())
                .password(bCryptPasswordEncoder.encode(signupRequestDto.getPassword())) // 비밀번호는 DB에서도 암호화해서 저장
                .nickName(signupRequestDto.getNickName())
                .accountType(AccountType.NORMAL.name())
                .build();

        account = accountRepository.save(account);
        return account;
    }
}
