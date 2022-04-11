package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.model.dto.responseDto.ResponseDto;
import com.fshop.fashionshop.service.UserService;
import com.fshop.fashionshop.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    ResponseEntity<ResponseDto> signUp(@RequestBody User user) {


        if (!UserValidator.checkUserSignUp(user)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "user data is invalid to signUp"
            );
        }
        User user1 = userService.create(user);
        ResponseDto responseDto=new ResponseDto("User is log in");
        responseDto.addInfo("UserId", String.valueOf(user));
        return ResponseEntity.ok(responseDto);
    }
}