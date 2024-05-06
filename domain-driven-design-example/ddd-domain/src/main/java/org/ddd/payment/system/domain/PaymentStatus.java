package org.ddd.payment.system.domain;

import lombok.Getter;
import org.ddd.payment.system.BaseStatus;

/**
 * 支付状态机
 *
 * @since 2024/5/6
 */
@Getter
public enum PaymentStatus implements BaseStatus {
    /**
     * 初始化
     */
    INIT("INIT", "初始化"),
    /**
     * 支付中
     */
    PAYING("PAYING", "支付中"),
    /**
     * 支付成功
     */
    PAID("PAID", "支付成功"),
    /**
     * 支付失败
     */
    FAILED("FAILED", "支付失败"),
    ;

    /**
     * 支付状态机内容
     */
    private static final StateMachine<PaymentStatus, PaymentEvent> STATE_MACHINE = new StateMachine<>();
    static {
        // 初始状态
        STATE_MACHINE.accept(null, PaymentEvent.PAY_CREATE, INIT);
        // 支付中
        STATE_MACHINE.accept(INIT, PaymentEvent.PAY_PROCESS, PAYING);
        // 支付成功
        STATE_MACHINE.accept(PAYING, PaymentEvent.PAY_SUCCESS, PAID);
        // 支付失败
        STATE_MACHINE.accept(PAYING, PaymentEvent.PAY_FAIL, FAILED);
    }

    /**
     * 状态
     */
    private final String status;
    /**
     * 状态描述
     */
    private final String description;

    PaymentStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    /**
     * 通过源状态和事件类型获取目标状态
     */
    public static PaymentStatus getTargetStatus(PaymentStatus sourceStatus, PaymentEvent event) {
        return STATE_MACHINE.getTargetStatus(sourceStatus, event);
    }
}
