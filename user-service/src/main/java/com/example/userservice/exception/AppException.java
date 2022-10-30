package com.example.userservice.exception;

import com.example.userservice.constant.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AppException extends RuntimeException{

    private ErrorCode errorCode;
    private Integer httpStatusCode;

    public AppException(ErrorCode code, Integer httpStatusCode) {
        super(code.getMessage());
        this.errorCode = code;
        this.httpStatusCode = httpStatusCode;
    }
}
