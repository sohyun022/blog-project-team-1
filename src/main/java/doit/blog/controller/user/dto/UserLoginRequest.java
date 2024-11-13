package doit.blog.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
//레코드 타입이 뭐였지
public record UserLoginRequest(
        @Schema(description = "아이디", example = "testId")
        String userLoginId,

        @Schema(description = "비밀번호", example = "testPassword")
        String userPassword
) {
}
