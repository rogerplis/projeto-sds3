package com.roger.backend.payload.response;

import com.roger.backend.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

    private String jwt;
    private String type = "Bearer";
    private List<String> roles;
    private UserDto user;


    public JwtResponse(String accessToken, List<String> roles, UserDto user) {
        this.jwt = accessToken;
        this.roles = roles;
        this.user = user;
    }


}
