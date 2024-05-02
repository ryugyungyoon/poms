package com.jg.poms.service;

import com.jg.poms.domain.user.User;
import com.jg.poms.domain.user.UserRepository;
import com.jg.poms.dto.user.request.UserCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(UserCreateRequest request) {

        return userRepository.save(new User(request));
    }
    @Transactional
    public String certify(String contactNumber) {
        return contactNumber;
    }
}
