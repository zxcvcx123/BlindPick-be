package com.example.blindpersonpickerbe.controller.member;

import com.example.blindpersonpickerbe.entity.member.Member;
import com.example.blindpersonpickerbe.service.member.MemberService;
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

    @PostMapping("/checkid")
    public boolean memberCheckId(@RequestBody String id){
        System.out.println("중복체크할 ID: " + id);
        if(id.length() > 0){
            return true;
        } else {
            return false;
        }
    }

}
