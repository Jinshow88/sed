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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public ResponseEntity<PostUserResponseDto> postUser(PostUserRequestDto dto) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<GetUserResponseDto> getUser(GetUserRequestDto dto) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<DeleteUserResponseDto> deleteUser(DeleteUserRequestDto dto) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<UpdateUserResponseDto> updateUser(UpdateUserRequestDto dto) {
        return null;
    }

}
