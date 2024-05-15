package com.jg.poms.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsById(String id);
	//boolean existsByNickname(String nickname);
	//Optional<User> findById(String id);
	User findById(String id);
}
