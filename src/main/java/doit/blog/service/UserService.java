package doit.blog.service;

import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserSignUpRequest;

public interface UserService {
    void validateDuplicateId(String userLoginId);
    UserIdResponse signUp(UserSignUpRequest userSignUpRequest);
    UserIdResponse login(UserLoginRequest userLoginRequest);
    UserInfoResponse getUserInfo(Long userId);
}
