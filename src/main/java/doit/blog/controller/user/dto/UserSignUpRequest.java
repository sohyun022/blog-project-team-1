package doit.blog.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UserSignUpRequest(

        @Schema(description = "아이디", example = "testId")
        String userLoginId,

        @Schema(description = "비밀번호", example = "testPassword")
        @NotBlank
        String userPassword,

        @Schema(description = "이름", example = "홍길동")
        @NotBlank
        String userName,

        @Schema(description = "닉네임", example = "각시탈")
        @NotBlank
        String userNickname,

        @Schema(description = "전화번호", example = "010-1234-5678")
        String userPhoneNumber
) {
}
