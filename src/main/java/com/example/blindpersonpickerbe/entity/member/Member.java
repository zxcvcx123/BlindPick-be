package com.example.blindpersonpickerbe.entity.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Data
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name= "member_id", nullable = false)
    private String memberId;

    @Column(name= "member_pw", nullable = false)
    private String memberPw;

    @Column(name= "member_name", nullable = false)
    private String memberName;

    @Column(name= "member_email", nullable = false)
    private String memberEmail;

    @Column(name= "member_birth", nullable = false)
    private LocalDateTime memberBirth;

    @Column(name= "member_created")
    private LocalDateTime memberCreated = LocalDateTime.now();

    @Column(name= "member_updated")
    private LocalDateTime memberUpdated;

    @Column(name= "member_role")
    private LocalDateTime memberRole;

}
