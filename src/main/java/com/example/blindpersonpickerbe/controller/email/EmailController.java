package com.example.blindpersonpickerbe.controller.email;

import com.example.blindpersonpickerbe.dto.email.EmailCheckDTO;
import com.example.blindpersonpickerbe.dto.email.EmailRequestDTO;
import com.example.blindpersonpickerbe.service.email.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    // 이메일 인증번호 보내기
    // Request: 이메일 주소
    // Response: 인증번호
    @PostMapping("/checkemail")
    public String emailSend(@RequestBody @Valid EmailRequestDTO emailRequestDTO) {
        System.out.println("이메일 인증번호 요청");
        System.out.println("이메일 인증 이메일: " + emailRequestDTO.getEmail());
        return emailService.joinEmail(emailRequestDTO.getEmail());
    }

    // 이메일 인증번호 인증하기
    // Request: 이메일 주소, 인증번호
    @PostMapping("/checkemailauth")
    public String emailAuthCheck(@RequestBody @Valid EmailCheckDTO emailCheckDTO) {

        Boolean checked = emailService.emailAuthCheck(emailCheckDTO);

        if (checked) {
            return "ok";
        } else {
            throw new NullPointerException("뭔가 잘못!");

        }


    }

}
