package com.example.blindpersonpickerbe.config.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class GoogleEmailConfig {

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String userEmail;

    @Value("${spring.mail.password}")
    private String mailPassword;



    //JAVA MAILSENDER 인터페이스를 구현한 객체를 빈으로 등록하기 위함.
    @Bean
    public JavaMailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); //JavaMailSender 의 구현체를 생성하고
        mailSender.setHost(host); // 속성을 넣기 시작합니다. 이메일 전송에 사용할 SMTP 서버 호스트를 설정
        mailSender.setPort(port); // 587로 포트 지정
        mailSender.setUsername(userEmail); // 구글계정 넣기
        mailSender.setPassword(mailPassword); //구글 앱 비밀번호 넣기 / 암호 은닉화를 위해 @Value 어노테이션으로 properties에 정의된 암호를 가져옴

        Properties javaMailProperites = getJavaMailProperites();

        mailSender.setJavaMailProperties(javaMailProperites); // mailSender에 우리가 만든 properties 넣기

        return mailSender; // Bean으로 등록

    }

    private Properties getJavaMailProperites() {
        Properties javaMailProperites = new Properties(); // JavaMail의 속성을 설정하기 위해 Properties 객체를 생성
        javaMailProperites.put("mail.transport.protocol", "smtp"); // smtp 프로토콜 사용
        javaMailProperites.put("mail.smtp.auth", "true"); // smtp 서버에 인증이 필요
        javaMailProperites.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL 소켓 팩토리 클래스 사용
        javaMailProperites.put("mail.smtp.starttls.enable", "true"); // STARTTLS(TLS를 시작하는 명령)를 사용하여 암호화된 통신을 활성화
        javaMailProperites.put("mail.debug", "true"); // 디버깅 정보 출력
        javaMailProperites.put("mail.smtp.protocols", "TLSv1.2"); // 사용할 ssl 프로토콜 버전
        return javaMailProperites; // 설정 값을 return
    }

}
