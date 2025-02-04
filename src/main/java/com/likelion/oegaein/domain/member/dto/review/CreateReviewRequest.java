package com.likelion.oegaein.domain.member.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion.oegaein.domain.member.entity.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateReviewRequest extends ReviewData {
    @JsonProperty("receiver_id")
    private Long receiverId;
}