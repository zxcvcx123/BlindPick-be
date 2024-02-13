package com.example.blindpersonpickerbe.controller.email;

import com.example.blindpersonpickerbe.dto.email.EmailCheckDTO;
import com.example.blindpersonpickerbe.dto.email.EmailRequestDTO;
import com.example.blindpersonpickerbe.service.email.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    // TODO: ResponseEntity로 구조 바꾸기
    @PostMapping("/checkemailauth")
    public ResponseEntity emailAuthCheck(@RequestBody @Valid EmailCheckDTO emailCheckDTO) {

        Boolean checked = emailService.emailAuthCheck(emailCheckDTO);

        // 인증번호가 맞으면 ok 200
        // 틀리면 Bad Request 400
        if (checked) {
            return ResponseEntity.ok().build();
        } else {
            throw new NullPointerException("잘못된 인증번호 입니다!");
        }


    }

}
