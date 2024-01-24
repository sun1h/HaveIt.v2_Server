package com.haveit.account.entity;

import com.haveit.account.enums.MemberState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity(name = "accounts") //accounts table 생성
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
public class Account {
    @Id //기본 키 역할
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 자동 +1
    private Long memberId;
    @NotNull // 이메일 입력 필수
    private String email;
    @NotNull
    private String password;
    private String nickName;
    private String accountType; //NORMAL, KAKAO, GOOGLE, ADMIN
    private String state; //ACTIVE,DELETE
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Account(String email, String password, String nickName, String accountType, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.accountType = accountType;
        this.state = MemberState.ACTIVE.name(); //기본적으로 ACTIVE 설정
        this.createdAt = createdAt;
    }
}
