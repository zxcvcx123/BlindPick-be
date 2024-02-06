package com.example.blindpersonpickerbe.controller.email;

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

    @PostMapping("/checkmail")
    public String emailSend(@RequestBody @Valid EmailRequestDTO emailRequestDTO){
        System.out.println("이메일 인증 이메일: " + emailRequestDTO.getEmail());
        return emailService.joinEmail(emailRequestDTO.getEmail());
    }

}
