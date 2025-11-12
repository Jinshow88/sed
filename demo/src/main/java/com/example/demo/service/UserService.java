package com.example.demo.service;

import com.example.demo.dto.request.DeleteUserRequestDto;
import com.example.demo.dto.request.GetUserRequestDto;
import com.example.demo.dto.request.PostUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.dto.response.DeleteUserResponseDto;
import com.example.demo.dto.response.GetUserResponseDto;
import com.example.demo.dto.response.PostUserResponseDto;
import com.example.demo.dto.response.UpdateUserResponseDto;

import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<PostUserResponseDto> postUser(PostUserRequestDto dto);

    public ResponseEntity<GetUserResponseDto> getUser(GetUserRequestDto dto);

    public ResponseEntity<DeleteUserResponseDto> deleteUser(DeleteUserRequestDto dto);

    public ResponseEntity<UpdateUserResponseDto> updateUser(UpdateUserRequestDto dto);
}
