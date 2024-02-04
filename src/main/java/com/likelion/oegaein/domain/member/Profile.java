package com.likelion.oegaein.domain.member;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
@Builder
@Transactional
public class Profile {
    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;
    @Column(unique = true)
    private String name;
    private Gender gender;
    private int studentNo;
    private String major;
    private Date birthdate;
    private Dormitory dormitory;
    private Mbti mbti;
    private Smoking smoking;
    private SleepingHabit sleepingHabit;
    private LifePattern lifePattern;
    private Outing outing;
    private CleaningCycle cleaningCycle;
    private Sensitivity soundSensitivity;
    private String introduce;
    private int star;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;
}
