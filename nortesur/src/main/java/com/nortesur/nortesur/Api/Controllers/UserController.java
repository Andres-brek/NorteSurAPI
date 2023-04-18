package com.nortesur.nortesur.Api.Controllers;

import com.nortesur.nortesur.Api.Dtos.UserDto;
import com.nortesur.nortesur.Api.Dtos.UserMapper;
import com.nortesur.nortesur.entidades.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nortesur.nortesur.services.UserService;


@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mapToDto(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getAllUsers().stream().map(u->UserMapper.mapToDto(u)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User userCreated = userService.createUser(UserMapper.mapToEntity(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mapToDto(userCreated));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User userUpdated = userService.updateUser(id, UserMapper.mapToEntity(userDto)).get();
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mapToDto(userUpdated));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
