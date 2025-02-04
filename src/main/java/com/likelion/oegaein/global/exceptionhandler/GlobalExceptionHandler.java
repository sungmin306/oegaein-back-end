package com.likelion.oegaein.global.exceptionhandler;

import com.likelion.oegaein.domain.email.exception.EmailException;
import com.likelion.oegaein.domain.matching.exception.MatchingPostException;
import com.likelion.oegaein.domain.matching.exception.MatchingRequestException;
import com.likelion.oegaein.domain.member.exception.MemberException;
import com.likelion.oegaein.global.dto.ErrorResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // constants
    private final String COMMON_ERR_MSG_KEY = "errorMessage";
    // IllegalException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    // EntityNotFoundException
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(EntityNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    // MemberException
    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ErrorResponseDto> handleMemberException(MemberException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    // MatchingPostException
    @ExceptionHandler(MatchingPostException.class)
    public ResponseEntity<ErrorResponseDto> handleMatchingPostException(MatchingPostException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    // MatchingRequestException
    @ExceptionHandler(MatchingRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleMatchingRequestException(MatchingRequestException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    // MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentationValidExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            if(error instanceof FieldError){
                errors.put(((FieldError)error).getField(), error.getDefaultMessage());
            }else{
                errors.put(COMMON_ERR_MSG_KEY, error.getDefaultMessage());
            }
        });
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    // EmailException
    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorResponseDto> handleMatchingPostException(EmailException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex){
        Map<String, String> errors = new HashMap<>();
        errors.put(COMMON_ERR_MSG_KEY, ex.getMessage());
        final ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessages(errors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
