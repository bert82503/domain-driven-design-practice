package org.ddd.bank.exception;

/**
 * 业务异常
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public static BizException of(String message) {
        return new BizException(message);
    }

}
