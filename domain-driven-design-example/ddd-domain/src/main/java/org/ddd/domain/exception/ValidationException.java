package org.ddd.domain.exception;

/**
 * 参数校验异常
 *
 * @author guang.yi
 * @since 2023/12/23
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
