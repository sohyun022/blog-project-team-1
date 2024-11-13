package doit.blog.service;

import doit.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public boolean isDuplicated(String id){

        return userRepository.findByUserLoginId(id) != null;
    }
}
