package com.haveit.account.global.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration  //설정 클래스
@EnableEncryptableProperties //Jasypt 라이브러리 프로퍼티값 암호화 저장, 복호화
public class JasyptConfig {
    @Value("${jasypt.encryptor.password}") //yml에서 쉽게 변동
    private String encryptKey;

    @Primary // 우선순위
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPoolSize(4);
        config.setPassword(encryptKey);
        config.setAlgorithm("PBEWithMD5AndDES"); //암호화 알고리즘
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); //솔트 생성
        encryptor.setConfig(config);
        return encryptor;
    }
}
