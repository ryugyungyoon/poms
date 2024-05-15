package com.jg.poms.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jg.poms.dto.user.request.UserCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userIdx = null;
	@Column(nullable = false, length = 25)
	private String id;
	@Column(nullable = false)
	private String pw;
	@Column(length = 30)
	private String name;
	@Column(length = 8)
	private String birthday;
	@Column(length = 1)
	private String gender;
	@Column(length = 50)
	private String email;
	@Column(length = 11)
	private String contactNumber;
	@Column(length = 5)
	private String postNumber;
	@Column(length = 100)
	private String address;
	@Column(length = 100)
	private String addressDetail;
	private LocalDateTime registrationDate;
	private LocalDateTime modifyDate;

	private String role;

    /*
    @Enumerated(EnumType.STRING)
    private Role role;
    */

    /*
    protected User(){}
    */

	public User() {
	}

	public User(UserCreateRequest request) {
		if (request.getId() == null || request.getId().isBlank()) {
			throw new IllegalArgumentException(String.format("잘못된 id(%s)이 들어왔습니다.", request.getId()));
		} else if (request.getPw() == null || request.getPw().isBlank()) {
			throw new IllegalArgumentException(String.format("잘못된 pw(%s)이 들어왔습니다.", request.getPw()));
		}
		this.id = request.getId();
		this.pw = request.getPw();
		this.name = request.getName();
		this.birthday = request.getBirthday();
		this.gender = request.getGender();
		this.email = request.getEmail();
		this.contactNumber = request.getContactNumber();
		this.postNumber = request.getPostNumber();
		this.address = request.getAddress();
		this.addressDetail = request.getAddressDetail();
		this.role = "ROLE_USER";
	}
}
