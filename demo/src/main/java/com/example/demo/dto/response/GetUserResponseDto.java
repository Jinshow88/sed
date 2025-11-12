package com.example.demo.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.demo.common.GlobalConst.SUCCESS_CODE;
import static com.example.demo.common.GlobalConst.SUCCESS_MESSAGE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDto extends ResponseDto {

    private GetUserResponseDto() {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<GetUserResponseDto> success() {
        GetUserResponseDto result = new GetUserResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}