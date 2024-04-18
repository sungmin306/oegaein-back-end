package com.likelion.oegaein.domain.alarm.entity;

import com.likelion.oegaein.domain.matching.entity.MatchingPost;
import com.likelion.oegaein.domain.member.entity.profile.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoommateAlarm {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingpost_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MatchingPost matchingPost;

    @Enumerated(value = EnumType.STRING)
    private RoommateAlarmType alarmType;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
