package org.ddd.bank.exception;

/**
 * 账户未找到异常
 *
 * @author guang.yi
 * @since 2023/12/31
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
