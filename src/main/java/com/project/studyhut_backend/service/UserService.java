package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Role;
import com.project.studyhut_backend.model.User;

public interface UserService {
    User register(String email, String username, String name, String password, String repeatPassword, Role role);
    User login(String username, String password);
}