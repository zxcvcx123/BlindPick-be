package com.example.blindpersonpickerbe.service.member;


import com.example.blindpersonpickerbe.entity.member.Member;
import com.example.blindpersonpickerbe.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void memberSave(Member member){
        System.out.println("저장 시작");
        System.out.println(memberRepository.save(member));
        System.out.println("저장 끝");

    }



}
