package doit.blog.exception;

import lombok.Getter;

@Getter
public enum CustomErrorInfo {

    // 400 BAD_REQUEST
    INVALID_PASSWORD_FORMAT(400, "올바른 비밀번호 형식이 아닙니다.", 400001),
    INVALID_ID_OR_PASSWORD(400,"아이디 또는 비밀번호가 잘못되었습니다.",400002),
    ID_DUPLICATION(400, "중복된 아이디입니다.", 400003),

    // 401 UNAUTHORIZED

    // 403 FORBIDDEN

    // 404 NOT_FOUND
    USER_NOT_FOUND(404, "존재하지 않는 멤버입니다.", 404001),

    // 409 CONFLICT


    // 500 INTERNAL_SERVER_ERROR
    INTERNAL_SERVER_ERROR(500, "서버 내부 오류", 500001);

    private final int statusCode;
    private final String message;
    private final int detailStatusCode;

    CustomErrorInfo(int statusCode, String message, int detailStatusCode) {
        this.statusCode = statusCode;
        this.message = message;
        this.detailStatusCode = detailStatusCode;
    }
}
