package com.example.demo.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.demo.common.GlobalConst.SUCCESS_CODE;
import static com.example.demo.common.GlobalConst.SUCCESS_MESSAGE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponseDto extends ResponseDto{
    
    private UpdateUserResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<UpdateUserResponseDto> success(){
        UpdateUserResponseDto result = new UpdateUserResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
