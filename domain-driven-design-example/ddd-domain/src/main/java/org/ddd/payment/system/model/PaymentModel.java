package org.ddd.payment.system.model;

import lombok.Data;
import org.ddd.payment.system.StateMachineException;
import org.ddd.payment.system.domain.PaymentEvent;
import org.ddd.payment.system.domain.PaymentStatus;

/**
 * 支付单模型
 *
 * @since 2024/5/6
 */
@Data
public class PaymentModel {
    /**
     * 上次状态
     */
    private PaymentStatus lastStatus;
    /**
     * 当前状态
     */
    private PaymentStatus currentStatus;

    /**
     * 根据事件推进状态
     */
    public void transferStatusByEvent(PaymentEvent event) {
        // 根据当前状态和事件，去获取目标状态
        PaymentStatus targetStatus = PaymentStatus.getTargetStatus(currentStatus, event);
        // 如果目标状态不为空，说明是可以推进的
        if (targetStatus != null) {
            lastStatus = currentStatus;
            currentStatus = targetStatus;
        } else {
            // 目标状态为空，说明是非法推进，进入异常处理，这里只是抛出去，由调用者去具体处理
            throw new StateMachineException(currentStatus, event, "状态转换失败");
        }
    }
}
