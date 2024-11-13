package doit.blog.service;

import doit.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public void validateDuplicateId(String userLoginId){
        if (userRepository.existsByUserLoginId(userLoginId)) {
            throw new CustomException(CustomErrorInfo.ID_DUPLICATION);
        }
    }
}
