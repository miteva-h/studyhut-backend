package com.project.studyhut_backend.web;

import com.project.studyhut_backend.mapper.UserMapper;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.RegistrationForm;
import com.project.studyhut_backend.model.dtos.UserDto;
import com.project.studyhut_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody RegistrationForm registrationForm) {
        User user = userService.register(registrationForm.getEmail(), registrationForm.getUsername(),
                registrationForm.getPassword(), registrationForm.getRepeatPassword(), registrationForm.getName(),
                registrationForm.getRole());
        UserDto userDto = UserMapper.INSTANCE.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
