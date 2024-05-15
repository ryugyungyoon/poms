package com.jg.poms.service.user;

import com.jg.poms.domain.user.User;
import com.jg.poms.domain.user.UserRepository;
import com.jg.poms.dto.user.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepository.findById(userId);

		if(user != null) {
			return new CustomUserDetails(user);
		}

		return null;
	}

}
