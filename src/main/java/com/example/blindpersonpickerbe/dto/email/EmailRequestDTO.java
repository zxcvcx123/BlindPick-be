package com.example.blindpersonpickerbe.dto.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmailRequestDTO {

    // @Email Validation (유효성 검증 어노테이션)
    // 1. @기호를 포함
    // 2. @기호를 기준으로 이메일 주소를 이루는 로컬호스트와 도메인 파트가 존재해야함
    // 3. 도메인 파트는 최소 하나의 점과 그 뒤에 최소한의 2개의 알파베을 가진다
    // @NotEmpty (유효성 검증이 불일치한 경우 메세지 출력)
    @Email
    @NotEmpty(message = "이메일을 입력해 주세요.")
    private String email;
}
