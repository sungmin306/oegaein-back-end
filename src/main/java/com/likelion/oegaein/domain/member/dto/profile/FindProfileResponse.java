package com.likelion.oegaein.domain.member.dto.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.likelion.oegaein.domain.member.entity.profile.*;
import com.likelion.oegaein.domain.member.repository.SleepingHabitRepository;
import com.likelion.oegaein.global.dto.ResponseDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FindProfileResponse implements ResponseDto {
    private String name; // 닉네임
    private String introduction; // 소개글
    @Enumerated(EnumType.STRING)
    private Gender gender; // 성별
    private int studentNo; // 학번
    private Major major;
    private Date birthdate; // 생일
    @Enumerated(EnumType.STRING)
    private Mbti mbti; // MBTI
    private List<SleepingHabit> sleepingHabit; // 수면 습관
    @Enumerated(EnumType.STRING)
    private LifePattern lifePattern; // 생활 패턴
    @Enumerated(EnumType.STRING)
    private Smoking smoking; // 흡연 여부
    @Enumerated(EnumType.STRING)
    private CleaningCycle cleaningCycle; // 청소 주기
    @Enumerated(EnumType.STRING)
    private Outing outing; // 외출 빈도
    @Enumerated(EnumType.STRING)
    private Sensitivity soundSensitivity; // 소리 민감도
    // 후기

    public static FindProfileResponse of(Profile profile) {;
        List<SleepingHabit> sleepingHabit = profile.getSleepingHabit().stream()
                .map(SleepingHabitEntity::getSleepingHabit)
                .collect(Collectors.toList());

        return FindProfileResponse.builder()
                .name(profile.getName())
                .introduction(profile.getIntroduction())
                .gender(profile.getGender())
                .studentNo(profile.getStudentNo())
                .major(profile.getMajor())
                .birthdate(profile.getBirthdate())
                .mbti(profile.getMbti())
                .sleepingHabit(sleepingHabit)
                .lifePattern(profile.getLifePattern())
                .smoking(profile.getSmoking())
                .cleaningCycle(profile.getCleaningCycle())
                .outing(profile.getOuting())
                .soundSensitivity(profile.getSoundSensitivity())
                .build();
    }


}
