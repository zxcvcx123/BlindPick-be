package com.example.blindpersonpickerbe.controller.member;

import com.example.blindpersonpickerbe.entity.member.Member;
import com.example.blindpersonpickerbe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity memberSave(@RequestBody Member member){

        System.out.println(member);
        memberService.memberSave(member);

        return ResponseEntity.ok().build();
    }


}
