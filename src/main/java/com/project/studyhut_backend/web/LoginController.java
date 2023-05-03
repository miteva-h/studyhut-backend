package com.project.studyhut_backend.web;

import com.project.studyhut_backend.mapper.UserMapper;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.LoginForm;
import com.project.studyhut_backend.model.dtos.UserDto;
import com.project.studyhut_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @PostMapping("/post")
    public ResponseEntity<UserDto> login(@RequestBody LoginForm loginForm) {
        User user = userService.login(loginForm.getUsername(), loginForm.getPassword());
//        UserDto userDto = UserMapper.INSTANCE.toDto(user);
        UserDto userDto = userService.getUser(user.getUserID());
        return ResponseEntity.ok(userDto);
    }
}
