package com.likelion.oegaein.domain.member;

import com.likelion.oegaein.domain.global.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Transactional
public class Member extends BaseTime {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @OneToOne(mappedBy = "member")
    private Profile profile;
}
