package org.ddd.domain.exception;

/**
 * 无效货币异常
 *
 * @author guang.yi
 * @since 2023/12/28
 */
public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException(String message) {
        super(message);
    }

    public InvalidCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

}
