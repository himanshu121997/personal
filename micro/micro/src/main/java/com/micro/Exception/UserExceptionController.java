package com.micro.Exception;


import com.micro.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class UserExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class,UserNotfoundException.class}) // exception handled
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(UserNotfoundException.class) // exception handled
//    public ResponseEntity<ErrorResponse> handleExceptions(UserNotfoundException e) {
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
////        StringWriter stringWriter = new StringWriter();
////        PrintWriter printWriter = new PrintWriter(stringWriter);
////        e.printStackTrace(printWriter);
////        String stackTrace = stringWriter.toString();
//
//        return new ResponseEntity<>(
//                new ErrorResponse(
//                        status,
//                        e.getMessage()
////                        stackTrace // specifying the stack trace in case of 500s
//                ),
//                status
//        );
//    }
}