package com.likelion.oegaein.domain.matching.dto.reply;

import com.likelion.oegaein.global.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateReplyResponse implements ResponseDto {
    private Long replyId;
}
