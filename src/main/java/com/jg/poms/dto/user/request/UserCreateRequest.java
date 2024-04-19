package com.jg.poms.dto.user.request;

import lombok.*;

@Getter
@AllArgsConstructor
public class UserCreateRequest {

    private String id;
    private String pw;
    private String name;
    private String birthday;
    private String gender;
    private String email;
    private String contactNumber;
    private String postNumber;
    private String address;
    private String addressDetail;

}
