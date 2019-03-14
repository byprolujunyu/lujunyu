package com.bm.container.http;


/**
 * 自定义异常处理
 * <p>
 * Created by nfmomo on 17/4/1.
 */

public class ApiException extends RuntimeException {
    private String status;

    public ApiException(String status, String message) {
        super(message);
    }

}