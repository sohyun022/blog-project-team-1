package doit.blog.service;

import doit.blog.controller.user.domain.User;
import doit.blog.controller.user.dto.*;
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
    @Transactional(readOnly = true)
    public void validateIdOrPasswordFormat(String userLoginId,String userPassword) {
        if(userLoginId.length() < 5 || userLoginId.length() > 30 || userPassword.length() < 5 || userPassword.length() > 30){
            throw new CustomException(CustomErrorInfo.INVALID_ID_OR_PASSWORD_LENGTH);
        }
        String regex = "^[a-zA-Z0-9]+$";

        if(!userLoginId.matches(regex) ){
            throw new CustomException(CustomErrorInfo.INVALID_ID_FORMAT);
        }
        if(!userPassword.matches(regex)){
            throw new CustomException(CustomErrorInfo.INVALID_PASSWORD_FORMAT);
        }
    }

    @Override
    public UserIdResponse signUp(UserSignUpRequest request){
        validateDuplicateId(request.userLoginId());
        validateIdOrPasswordFormat(request.userLoginId(),request.userPassword());
        User user = User.create(request,passwordEncoder);
        userRepository.save(user);

        return UserIdResponse.from(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserIdResponse login(UserLoginRequest request){
        User user = userRepository.findByUserLoginId(request.userLoginId());
        if (user == null || !passwordEncoder.matches(request.userPassword(), user.getUserPassword())) {
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

    @Override
    public UserIdResponse updateUserInfo(Long userId, UserInfoUpdateRequest request){
        if (userId == null) {
            throw new CustomException(CustomErrorInfo.SESSION_NOT_FOUND);
        }
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new CustomException(CustomErrorInfo.USER_NOT_FOUND));
        user.UserInfoUpdate(request);

        return UserIdResponse.from(user);
    }

    @Override
    public void deleteUserInfo(Long userId){
        userRepository.findById(userId)
                .orElseThrow(()-> new CustomException(CustomErrorInfo.USER_NOT_FOUND));

        userRepository.deleteById(userId);
    }
}
