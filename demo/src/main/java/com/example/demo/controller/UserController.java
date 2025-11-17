package com.example.demo.controller;

import com.example.demo.dto.request.DeleteUserRequestDto;
import com.example.demo.dto.request.GetUserRequestDto;
import com.example.demo.dto.request.PostUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.dto.response.DeleteUserResponseDto;
import com.example.demo.dto.response.GetUserResponseDto;
import com.example.demo.dto.response.PostUserResponseDto;
import com.example.demo.dto.response.UpdateUserResponseDto;
import com.example.demo.service.UserService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "유저")
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    public ResponseEntity<PostUserResponseDto> postUser(@RequestBody PostUserRequestDto dto) {
        return service.postUser(dto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserResponseDto> deleteUser(@ParameterObject DeleteUserRequestDto dto) {
        return service.deleteUser(dto);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateUserResponseDto> updateUser(@RequestBody UpdateUserRequestDto dto) {
        return service.updateUser(dto);
    }

    @GetMapping("/get")
    public ResponseEntity<GetUserResponseDto> getUser(GetUserRequestDto dto) {
        return service.getUser(dto);
    }
    // @GetMapping("/get/{id}")
    // public ResponseEntity<GetUserResponseDto> getUser(@PathVariable
    // GetUserRequestDto dto){
    // return service.getUser(dto);
    // }
}
