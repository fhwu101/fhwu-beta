package com.fhwu.beta.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.fhwu.beta.entity.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author : fhwu
 * @ClassName : com.fhwu.beta.handler.GlobalExceptionHandler
 * @Description : 全局异常处理
 * @date : 2024/08/18 018 19:46
 */


@ControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Result<String>> handleNotFoundException(NotLoginException ex) {
        return new ResponseEntity<>(Result.error("用户未登录"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
