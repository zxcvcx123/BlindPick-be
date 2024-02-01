package com.example.blindpersonpickerbe.repository.member;

import com.example.blindpersonpickerbe.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;


public interface MemberRepository extends JpaRepository<Member, Long> {



}
