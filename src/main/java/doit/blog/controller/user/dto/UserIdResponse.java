package doit.blog.controller.user.dto;

import doit.blog.controller.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserIdResponse(
        @Schema(description = "유저 식별 ID", example = "1")
        Long userId
) {
        public static UserIdResponse from(User user){
                return new UserIdResponse(user.getId());
        }
}
