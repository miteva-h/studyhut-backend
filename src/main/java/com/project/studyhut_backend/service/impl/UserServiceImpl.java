package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.*;
import com.project.studyhut_backend.model.Role;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.UserDto;
import com.project.studyhut_backend.repository.UserRepository;
import com.project.studyhut_backend.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User findByUsername(String username){
        return this.userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(InvalidUserCredentialsException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidUserCredentialsException();
        }

        return user;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (UserDetails) userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
//    }

    @Override
    public User register(String email, String username, String name, String password, String repeatPassword, Role role) {
        if (email==null || email.isEmpty() ||username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(email,username,name,password,role);
        return userRepository.save(user);
    }

    @Override
    public UserDto getUser(Integer userId) {
        User user = this.userRepository.findById(userId).get();
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
