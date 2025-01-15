package doit.blog.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserInfoUpdateRequest(
        @Schema(description = "이름", example = "문소현")
        String userName,

        @Schema(description = "닉네임", example = "문어빵")
        String userNickname,

        @Schema(description = "전화번호", example = "010-2239-5678")
        String userPhoneNumber
) {
}
