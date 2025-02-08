package org.qin.com.stock.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Getter;

import java.io.Serializable;

/**
 * 返回数据类
 * @JsonInclude 保证序列化json的时候,如果是null的对象,key也会消失
 * @param <T>
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiResponse
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 7735505903525411467L;

    // 成功值,默认为1
    private static final int SUCCESS_CODE = 1;
    // 失败值,默认为0
    private static final int ERROR_CODE = 0;

    //状态码
    private int code;
    //消息
    private String msg;
    //返回数据
    private T data;

    private CommonResponse(int code){
        this.code = code;
    }
    private CommonResponse(int code, T data){
        this.code = code;
        this.data = data;
    }
    private CommonResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private CommonResponse(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResponse<T> ok(){
        return new CommonResponse<T>(SUCCESS_CODE,"success");
    }
    public static <T> CommonResponse<T> ok(String msg){
        return new CommonResponse<T>(SUCCESS_CODE,msg);
    }
    public static <T> CommonResponse<T> ok(T data){
        return new CommonResponse<T>(SUCCESS_CODE,data);
    }
    public static <T> CommonResponse<T> ok(String msg, T data){
        return new CommonResponse<T>(SUCCESS_CODE,msg,data);
    }

    public static <T> CommonResponse<T> error(){
        return new CommonResponse<T>(ERROR_CODE,"error");
    }
    public static <T> CommonResponse<T> error(String msg){
        return new CommonResponse<T>(ERROR_CODE,msg);
    }
    public static <T> CommonResponse<T> error(int code, String msg){
        return new CommonResponse<T>(code,msg);
    }
    public static <T> CommonResponse<T> error(ResponseCode res){
        return new CommonResponse<T>(res.getCode(),res.getMessage());
    }

}