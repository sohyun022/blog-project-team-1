package doit.blog.service;

import doit.blog.controller.user.dto.UserSignUpRequest;

public interface UserService {
    void validateDuplicateId(String id);

    void signUp(UserSignUpRequest userSignUpRequest);

}
