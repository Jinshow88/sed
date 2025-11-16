package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.object.GetUserDto;
import com.example.demo.dto.request.DeleteUserRequestDto;
import com.example.demo.dto.request.GetUserRequestDto;
import com.example.demo.dto.request.PostUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.dto.response.DeleteUserResponseDto;
import com.example.demo.dto.response.GetUserResponseDto;
import com.example.demo.dto.response.PostUserResponseDto;
import com.example.demo.dto.response.UpdateUserResponseDto;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseEntity<PostUserResponseDto> postUser(PostUserRequestDto dto) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<GetUserResponseDto> getUser(GetUserRequestDto dto) {

        List<GetUserDto> userDtos = new ArrayList<>();
        List<Users> users = userRepository.findAll();
        for (Users user : users) {
            GetUserDto userDto = new GetUserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setAge(user.getAge());
            userDto.setIntroduce(user.getIntroduce());
            userDtos.add(userDto);
        }
    // ⭐ 1. Response용 DTO 만들어서 리스트 넣기
    GetUserResponseDto response = new GetUserResponseDto();
    response.setUserList(userDtos);
    response.setCount(userDtos.size());

    // ⭐ 2. ResponseEntity 로 감싸서 반환
    return ResponseEntity.ok(response);
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
