package doit.blog.exception;

import lombok.Getter;

@Getter
public enum CustomErrorInfo {

    // 400 BAD_REQUEST
    INVALID_ID_OR_PASSWORD(400,"아이디 또는 비밀번호가 잘못되었습니다.",400001),

    // 401 UNAUTHORIZED
    SESSION_NOT_FOUND(401,"세션이 존재하지 않습니다.",401001),

    // 403 FORBIDDEN

    // 404 NOT_FOUND
    USER_NOT_FOUND(404, "해당하는 유저를 찾을 수 없습니다.", 404002),

    // 409 CONFLICT
    INVALID_ID_FORMAT(409, "유효하지 않은 아이디 형식입니다. 영문자와 숫자만 사용해주세요.", 409001),
    ID_DUPLICATION(409, "중복된 아이디입니다.", 409002),
    INVALID_PASSWORD_FORMAT(409, "유효하지 않은 비밀번호 형식입니다. 영문자와 숫자만 사용해주세요.", 409003),
    INVALID_ID_OR_PASSWORD_LENGTH(409,"아이디 또는 비밀번호는 5글자 이상 30글자 이하여야 합니다.",409004),

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
