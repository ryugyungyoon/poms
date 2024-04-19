package com.jg.poms.service;

import com.jg.poms.domain.user.User;
import com.jg.poms.domain.user.UserRepository;
import com.jg.poms.dto.user.request.UserCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserCreateRequest request){
        return userRepository.save(new User(request));
    }
}
