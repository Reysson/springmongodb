package com.reysson.springmongo.api.controller;

import com.reysson.springmongo.api.controller.dto.UserDto;
import com.reysson.springmongo.domain.model.User;
import com.reysson.springmongo.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> listUser = userService.findAll();
        List<UserDto> listUserDto = listUser.stream().
                 map(user -> new UserDto(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listUserDto);
    }
}
