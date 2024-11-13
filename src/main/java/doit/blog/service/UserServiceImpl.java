package doit.blog.service;

import doit.blog.controller.user.domain.User;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.exception.CustomErrorInfo;
import doit.blog.exception.CustomException;
import doit.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateDuplicateId(String userLoginId){
        if (userRepository.existsByUserLoginId(userLoginId)) {
            throw new CustomException(CustomErrorInfo.ID_DUPLICATION);
        }
    }

    @Override
    public void signUp(UserSignUpRequest userSignUpRequest){

        validateDuplicateId(userSignUpRequest.userLoginId());

        User user = User.builder()
                .userName(userSignUpRequest.userName())
                .userNickname(userSignUpRequest.userNickname())
                .userPassword(userSignUpRequest.userPassword())
                .userLoginId(userSignUpRequest.userLoginId())
                .userPhoneNumber(userSignUpRequest.userPhoneNumber())
                .build();

        userRepository.save(user);
    }


}
