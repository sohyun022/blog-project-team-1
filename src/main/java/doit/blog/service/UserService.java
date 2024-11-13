package doit.blog.service;

import doit.blog.controller.user.dto.UserLoginRequest;
import org.springframework.stereotype.Service;

public interface UserService {
    void validateDuplicateId(String id);

}
