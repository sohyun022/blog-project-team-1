package doit.blog.service;

import doit.blog.controller.user.dto.*;

public interface UserService {
    void validateDuplicateId(String userLoginId);
    void validateIdOrPasswordFormat(String userLoginId,String userPassword);
    UserIdResponse signUp(UserSignUpRequest userSignUpRequest);
    UserIdResponse login(UserLoginRequest userLoginRequest);
    UserInfoResponse getUserInfo(Long userId);
    UserIdResponse updateUserInfo(Long userId, UserInfoUpdateRequest userInfoUpdateRequest);
    void deleteUserInfo(Long userId);
}
