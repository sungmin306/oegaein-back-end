package com.likelion.oegaein.domain.member.dto.profile;

import com.likelion.oegaein.global.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProfileResponse implements ResponseDto {
    private Long profileId;
}