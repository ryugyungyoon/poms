package com.jg.poms.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

	Admin("ROLE_ADMIMN"),
	USER("ROLE_USER");

	private String name;
}
