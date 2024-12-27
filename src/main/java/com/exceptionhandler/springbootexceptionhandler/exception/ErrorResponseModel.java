package com.exceptionhandler.springbootexceptionhandler.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseModel {

        private int statusCode;
        private Long date;
        private String restErrorMessage;
        private String detailedErrorMessage;

}