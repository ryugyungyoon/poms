package com.jg.poms.domain.user;

import com.jg.poms.dto.user.request.UserCreateRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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

    protected User(){}

    public User(UserCreateRequest request) {
        if(request.getId() == null || request.getId().isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 id(%s)이 들어왔습니다.", request.getId()));
        }
        else if(request.getPw() == null || request.getPw().isBlank()){
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
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }
}
