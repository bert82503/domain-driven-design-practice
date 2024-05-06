package org.ddd.payment.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ddd.payment.system.StateMachineException;
import org.ddd.payment.system.domain.PaymentEvent;
import org.ddd.payment.system.domain.PaymentNotifyMessage;
import org.ddd.payment.system.model.PaymentModel;
import org.ddd.payment.system.service.PaymentDomainService;

/**
 * 支付领域域服务实现
 *
 * @since 2024/5/6
 */
@Slf4j
public class PaymentDomainServiceImpl implements PaymentDomainService {
    /**
     * 支付结果通知
     */
    public void notify(PaymentNotifyMessage message) {
        PaymentModel paymentModel = loadPaymentModel(message.getPaymentId());
        try {
            // 状态推进
            paymentModel.transferStatusByEvent(PaymentEvent.valueOf(message.getEvent()));
            savePaymentModel(paymentModel);
            // 其它业务处理
            // ...
        } catch (StateMachineException e) {
            // 异常处理
            // ...
        } catch (Exception e) {
            // 异常处理
            log.error("notify payment message fail, message={}", message, e);
        }
    }

    private PaymentModel loadPaymentModel(String paymentId) {
        // ToDo
        return new PaymentModel();
    }

    private void savePaymentModel(PaymentModel paymentModel) {
        // ToDo
    }
}
