package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Role;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String username;
    private String name;
    private Role role;

    public UserDto(){}

    public UserDto(String email, String username, String name, Role role){
        this.email=email;
        this.username=username;
        this.name=name;
        this.role=role;
    }
}
