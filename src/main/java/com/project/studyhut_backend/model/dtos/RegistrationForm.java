package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
    private String email;
    private String username;
    private String password;
    private String repeatPassword;
    private String name;
    private Role role;
}
