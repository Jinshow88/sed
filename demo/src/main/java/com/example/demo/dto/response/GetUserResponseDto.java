package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.dto.object.GetUserDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.demo.common.GlobalConst.SUCCESS_CODE;
import static com.example.demo.common.GlobalConst.SUCCESS_MESSAGE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetUserResponseDto extends ResponseDto {

    Integer count;
    List<GetUserDto> userList;

    public GetUserResponseDto(List<GetUserDto> userList, int count) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.userList = userList;
        this.count = count;
    }

    public static ResponseEntity<GetUserResponseDto> success(List<GetUserDto> userList, int count) {
        GetUserResponseDto result = new GetUserResponseDto(userList, count);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}