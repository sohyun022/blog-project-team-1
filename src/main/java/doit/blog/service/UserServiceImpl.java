package doit.blog.service;

import doit.blog.controller.user.domain.User;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.exception.CustomErrorInfo;
import doit.blog.exception.CustomException;
import doit.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public void validateDuplicateId(String userLoginId){
        if (userRepository.existsByUserLoginId(userLoginId)) {
            throw new CustomException(CustomErrorInfo.ID_DUPLICATION);
        }
    }

    @Override
    public UserIdResponse signUp(UserSignUpRequest userSignUpRequest){
        validateDuplicateId(userSignUpRequest.userLoginId());
        User user = User.create(userSignUpRequest,passwordEncoder);
        userRepository.save(user);
        return UserIdResponse.from(user);
    }

    @Override
    public UserIdResponse login(UserLoginRequest userLoginRequest){
        User user = userRepository.findByUserLoginId(userLoginRequest.userLoginId());
        if (user == null || !passwordEncoder.matches(userLoginRequest.userPassword(), user.getUserPassword())) {
            throw new CustomException(CustomErrorInfo.INVALID_ID_OR_PASSWORD);
        }
        return UserIdResponse.from(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfoResponse getUserInfo(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new CustomException(CustomErrorInfo.USER_NOT_FOUND));
        return UserInfoResponse.from(user);
    }
}
