package com.alibaba.bean.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Response implements Serializable {

    private String msg ;
    private int status ;
    private Object data ;

    public static Response success(String msg){
        return Response.builder().msg(msg).status(0).build();
    }
    public static Response success(String msg, Object data){
        return Response.builder().msg(msg).status(0).data(data).build();
    }
    public static Response failed(String msg){
        return Response.builder().msg(msg).status(1).data(null).build();
    }
}
