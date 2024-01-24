package com.haveit.account.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    public void jasyptTest(){

        String password = ""; //패스워드 값

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);

        String content = "";    // 암호화 할 내용
        String encryptedContent = encryptor.encrypt(content); // 암호화
        String decryptedContent = encryptor.decrypt(encryptedContent); // 복호화

        System.out.println("Enc : " + encryptedContent + ", Dec: " + decryptedContent); //ENC()안에 넣어 yml에 작성
    }
}