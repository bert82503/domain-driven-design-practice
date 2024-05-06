package org.ddd.payment.system.domain;

import lombok.Getter;

/**
 * 支付结果通知消息
 *
 * @since 2024/5/6
 */
@Getter
public class PaymentNotifyMessage {
    /**
     * 支付ID
     */
    private final String paymentId;
    /**
     * 支付事件
     */
    private final String event;

    public PaymentNotifyMessage(String paymentId, String event) {
        this.paymentId = paymentId;
        this.event = event;
    }
}
