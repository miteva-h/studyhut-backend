package com.project.studyhut_backend.web;

import com.project.studyhut_backend.mapper.UserMapper;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.RegistrationForm;
import com.project.studyhut_backend.model.dtos.UserDto;
import com.project.studyhut_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

//    @PostMapping
//    public ResponseEntity<UserDto> register(@RequestBody RegistrationForm registrationForm) {
//        User user = userService.register(registrationForm.getEmail(), registrationForm.getUsername(),
//                registrationForm.getName(), registrationForm.getPassword(), registrationForm.getRepeatPassword(),
//                registrationForm.getRole());
//        UserDto userDto = UserMapper.INSTANCE.toDto(user);
//        return ResponseEntity.ok(userDto);
//    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody RegistrationForm registrationForm) {
        User user = userService.register(registrationForm.getEmail(), registrationForm.getUsername(),
                registrationForm.getName(), registrationForm.getPassword(), registrationForm.getRepeatPassword(),
                registrationForm.getRole());
        UserDto userDto = this.userService.getUser(user.getUserID());
        return ResponseEntity.ok(userDto);
    }

    // update it with UserDto
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id){
        UserDto userDto = this.userService.getUser(id);
        return ResponseEntity.ok(userDto);
    }
}
