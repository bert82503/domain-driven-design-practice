package org.ddd.payment.system;

import lombok.Getter;
import lombok.ToString;

/**
 * 状态机异常
 *
 * @since 2024/5/6
 */
@Getter
@ToString
public class StateMachineException extends RuntimeException {
    private static final long serialVersionUID = -3687764138627597767L;
    /**
     * 指定的状态
     */
    private final BaseStatus status;
    /**
     * 可接受的事件
     */
    private final BaseEvent event;

    public StateMachineException(BaseStatus status, BaseEvent event, String message) {
        super(message);
        this.status = status;
        this.event = event;
    }
}
