package com.exceptionhandler.springbootexceptionhandler.exception;
import com.exceptionhandler.springbootexceptionhandler.utill.DateTimeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseModel handleRuntimeException(RuntimeException runtimeException){
        return ErrorResponseModel.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(runtimeException.getMessage())
                .detailedErrorMessage(runtimeException.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseModel usernameNotFoundException(UsernameNotFoundException usernameNotFoundException){
        return ErrorResponseModel.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(usernameNotFoundException.getMessage())
                .detailedErrorMessage(usernameNotFoundException.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseModel nullPointerException(NullPointerException nullPointerException){
        return ErrorResponseModel.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(nullPointerException.getMessage())
                .detailedErrorMessage(nullPointerException.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseModel badCredentialsException(BadCredentialsException badCredentialsException){
        return ErrorResponseModel.builder()
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(badCredentialsException.getMessage())
                .detailedErrorMessage(badCredentialsException.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseModel IllegalArgumentException(IllegalArgumentException illegalArgumentException){
        return ErrorResponseModel.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(illegalArgumentException.getMessage())
                .detailedErrorMessage(illegalArgumentException.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(CustomException.class)
    public ErrorResponseModel customException(CustomException customException){
        return ErrorResponseModel.builder()
                .statusCode(customException.getStatus().value())
                .date(DateTimeUtils.getCurrentUTCTime().getEpochSecond())
                .restErrorMessage(customException.getMessage())
                .detailedErrorMessage(customException.getLocalizedMessage())
                .build();
    }
}
