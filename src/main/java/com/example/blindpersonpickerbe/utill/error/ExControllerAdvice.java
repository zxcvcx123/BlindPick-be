package com.example.blindpersonpickerbe.utill.error;

import com.example.blindpersonpickerbe.dto.email.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.charset.Charset;

// 메일 인증번호 오류 관련 처리 부분
// TODO: 메일 인증번호 오류 처리 부분 코드 분석하기
@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResult> testing(NullPointerException e){
        ErrorResult errorResult = new ErrorResult("EMAIL", e.getMessage());

        // 이걸로 보내면 axios error 로 처리됨
        // 프론트에서 꺼내쓸 때 res.response.status 로 한번 더 꺼내써야함
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }
}
