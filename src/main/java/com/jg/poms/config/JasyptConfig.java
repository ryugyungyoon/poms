package com.jg.poms.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/application.yml")
public class JasyptConfig {

    @Value("${jasypt.encryptor.password}")
    private String password;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        //setPassword : 암호화 및 복호화에 사용할 비밀 키를 설정
        config.setPassword(password);
        //setAlgorithm : 암호화에서 사용할 알고리즘을 설정
        config.setAlgorithm("PBEWithMD5AndDES");
        //setKeyObtentionIterations : 암호화 키 생성 반복 횟수를 설정
        config.setKeyObtentionIterations("1000");
        //setPoolSize : 암호화에서 사용할 스레드 풀 크기를 설정
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        //setSaltGeneratorClassName : salt 생성 class 설정
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        //setStringOutputType : 암호화에서 생성된 문자열 출력 형식을 설정
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}

