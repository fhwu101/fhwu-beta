package com.fhwu.beta.entity.vo;

import java.io.Serializable;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.bookkeeping.entity.vo.Result
 * @Description : 通用返回对象
 * @date : 2024/08/17 017 12:29
 */

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS_CODE = "0000";
    private static final String SUCCESS_MESSAGE = "操作成功";
    private static final String FAIL_CODE = "1000";
    private static final String FAIL_MESSAGE = "操作失败";

    private String code;
    private String message;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {

    }
    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(String code, String message, T data){
        return new Result<T>(code, message, data);
    }

    public static <T> Result<T> success(String message, T data){
        return new Result<T>(SUCCESS_CODE, message, data);
    }

    public static <T> Result<T> success(String message){
        return new Result<T>(SUCCESS_CODE, message, null);
    }

    public static <T> Result<T> success( T data){
        return new Result<T>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> error(String code, String message, T data){
        return new Result<T>(code, message, data);
    }

    public static <T> Result<T> error(String code, String message){
        return new Result<T>(code, message, null);
    }

    public static <T> Result<T> error(String message){
        return new Result<T>(FAIL_CODE, message, null);
    }

    public static <T> Result<T> error(){
        return new Result<T>(FAIL_CODE, FAIL_MESSAGE, null);
    }


}
