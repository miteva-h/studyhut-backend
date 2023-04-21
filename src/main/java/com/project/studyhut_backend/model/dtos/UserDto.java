package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Role;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String username;
    private String name;
    private String password;
    private Role role;

    public UserDto(){}

    public UserDto(String email, String username, String name, String password, Role role){
        this.email=email;
        this.username=username;
        this.name=name;
        this.password=password;
        this.role=role;
    }
}
