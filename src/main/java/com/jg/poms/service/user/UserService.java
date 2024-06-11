package com.jg.poms.service.user;

import com.jg.poms.domain.user.User;
import com.jg.poms.domain.user.UserRepository;
import com.jg.poms.dto.user.request.UserCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public User saveUser(UserCreateRequest request) {
		//db에서 아이디 중복 체크

		//회원가입시 생성자에서 임시로 모든 ROLE 일반 유저로 세팅중. 관리자 로직 생기면 추가하기
		User joinUser = new User(request);
		//비밀번호 암호화
		joinUser.setPw(bCryptPasswordEncoder.encode(request.getPw()));

		return userRepository.save(joinUser);
	}
	@Transactional
	public String certify(String contactNumber) {
		return contactNumber;
	}

}
