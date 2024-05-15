package com.jg.poms.dto.user;

import com.jg.poms.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

	private User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	//권한 관련 작업을 하기 위한 role return
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});

		return collection;
	}

	//get Password 메서드
	@Override
	public String getPassword() {
		return user.getPw();
	}

	//get Username 메서드
	@Override
	public String getUsername() {
		return user.getId();
	}

	//하위 4개 메소드 - 현재 poms db에 해당 컬럼 없으므로 모두 true로 세팅
	//계정이 만료 되었는지 (true: 만료X)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겼는지 (true: 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호가 만료되었는지 (true: 만료X)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정이 활성화(사용가능)인지 (true: 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
}
