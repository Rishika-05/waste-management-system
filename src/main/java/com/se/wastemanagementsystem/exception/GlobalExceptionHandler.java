package com.se.wastemanagementsystem.exception;

import com.se.wastemanagementsystem.utils.CoreResponse;
import io.jsonwebtoken.SignatureException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
//                                                        HttpStatus status, WebRequest request) {
//        if (ex instanceof MethodArgumentTypeMismatchException) {
//            String field = ((MethodArgumentTypeMismatchException) ex).getName();
//            return CoreResponse.buildWithHttpStatusAndMessage(HttpStatus.BAD_REQUEST, field);
//        }
//        return CoreResponse.buildWithHttpStatusAndMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
//            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
//            WebRequest request) {
//        return CoreResponse.buildWithHttpStatusAndMessage(HttpStatus.METHOD_NOT_ALLOWED,
//                ex.getMessage());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
//                                                               HttpStatus status, WebRequest request) {
//        return CoreResponse.buildWithHttpStatusAndMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    @Override
//    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
//                                                               HttpStatus status, WebRequest request) {
//        BindingResult result = ex.getBindingResult();
//        List<CustomError> errorMessagesList = new ArrayList<>();
//        for (FieldError fieldError : result.getFieldErrors()) {
//            errorMessagesList.add(CustomError.builder()
//                    .field(fieldError.getField())
//                    .message(fieldError.getDefaultMessage())
//                    .rejectedValue(fieldError.getRejectedValue())
//                    .build());
//        }
//        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_400", HttpStatus.BAD_REQUEST,
//                errorMessagesList);
//    }

    @ExceptionHandler({SwmsException.class})
    public ResponseEntity<Object> handleApplicationException(Exception ex,
                                                             HttpServletRequest httpRequest) {
        HttpStatus httpStatus = ((SwmsException) ex).getHttpStatusCode();
        String customCode = ((SwmsException) ex).getCustomCode();
        String errorMsg = ((SwmsException) ex).getInternalMessage();
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage(customCode, httpStatus,
                errorMsg);
    }

    // for invalid JWT token
    @ExceptionHandler({SignatureException.class})
    public ResponseEntity<Object> handleSignatureException(Exception ex,
                                                           HttpServletRequest httpRequest) {
        log.error(ex.getMessage());
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_400", HttpStatus.BAD_REQUEST,
                "Please login again to continue.");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleCustomException(ConstraintViolationException ex) {
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_400", HttpStatus.BAD_REQUEST,
                ex.getConstraintName());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleCustomException(AccessDeniedException ex) {
        return CoreResponse.buildWithCustomCodeAndHttpStatusAndMessage("INV_401", HttpStatus.UNAUTHORIZED,
                "Access Denied.");
    }

    @Getter
    @Setter
    @Builder
    public static class CustomError {
        private String field;
        private String message;
        private Object rejectedValue;
    }

}
