package com.example.blindpersonpickerbe.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private int authNumber; // 인증번호

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String userEmail;

    @Value("${spring.mail.password}")
    private String mailPassword;

    // 임의의 인증번호 6자리 생성하기
    private void authNumberMaker() {
        Random random = new Random();
        authNumber = random.nextInt(900000) + 100000;
    }

    // mail을 어디서 어디로 보내는지, 인증 번호의 형식 (html) 형식으로 디자인해서 보낼지 작성
    public String joinEmail(String email) {
        authNumberMaker();
        String setFrom = userEmail; // 보내는 사람의 이메일
        String toMail = email; // 받는 사람의 이메일
        String title = "블라인드 픽 회원가입 인증 이메일 입니다."; // 이메일 제목
        String content = "블라인드 픽 회원가입 인증 번호입니다." + // 이메일 본문 (html 형식)
                "<br><br>" +
                "인증번호: " + authNumber + "입니다.";
        emailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);

    }

    // 이메일 전송시키는 로직
    public void emailSend(String setFrom, String toMail, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();// JavaMailSender 객체를 사용하여 MimeMessage 객체를 생성
        try {
            // 이메일 메시지와 관련된 설정을 수행합니다.
            // true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom); // 이메일 발신자 주소
            helper.setTo(toMail); // 이메일 수신자 주소
            helper.setSubject(title); // 이메일 제목
            helper.setText(content, true); // 이메일 본문 , true로 설정해 html 설정으로 한다.
            mailSender.send(message);
        } catch (MessagingException e) {
            // 이메일 서버에 연결할 수 없거나, 잘못된 이메일 주소를 사용하거나, 인증 오류가 발생하는 등 오류
            // 이러한 경우 MessagingException이 발생
            e.printStackTrace();
        }

    }
}
