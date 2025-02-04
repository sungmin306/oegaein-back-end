package com.likelion.oegaein.domain.matching.entity;

import com.likelion.oegaein.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MatchingPostComment {
    @Id @GeneratedValue
    private Long id;
    private String content; // 댓글 내용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingpost_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MatchingPost matchingPost; // 게시글 FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member author; // 작성자 FK
    @CreationTimestamp
    private LocalDateTime createdAt; // 작성일
    @UpdateTimestamp
    private LocalDateTime modifiedAt; // 수정일
    private Boolean isDeleted; // 삭제 여부
    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private final List<MatchingPostReply> replies = new ArrayList<>();

    public void updateContent(String content){
        this.content = content;
    }
    public void updateDeleteStatus(){
        this.content = "삭제된 댓글입니다.";
        this.isDeleted = Boolean.TRUE;
    }
    public Boolean canDirectlyDelete(){
        for(MatchingPostReply reply : this.replies){
            if(reply.getIsDeleted().equals(Boolean.FALSE)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
