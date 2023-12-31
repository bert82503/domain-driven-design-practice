package org.ddd.bank.domain.model;

import lombok.Value;

/**
 * 响应结果【值对象】
 *
 * @author guang.yi
 * @since 2023/12/26
 */
@Value
public class Result<T> {

    private static final Integer SUCCESS_CODE = 0;

    Integer code;

    String message;

    T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, null, data);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}
