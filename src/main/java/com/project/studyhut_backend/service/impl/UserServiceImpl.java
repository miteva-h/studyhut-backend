package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.InvalidArgumentsException;
import com.project.studyhut_backend.exception.InvalidUsernameOrPasswordException;
import com.project.studyhut_backend.exception.PasswordsDoNotMatchException;
import com.project.studyhut_backend.exception.UsernameAlreadyExistsException;
import com.project.studyhut_backend.model.Role;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.UserRepository;
import com.project.studyhut_backend.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String email, String username, String name, String password, String repeatPassword, Role role) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username)!=null)
            throw new UsernameAlreadyExistsException(username);
        User user = new User(email, username,name,password,role);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
            if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
                throw new InvalidArgumentsException();
            }
            return userRepository.findByUsernameAndPassword(username,
                    password);
    }
}
