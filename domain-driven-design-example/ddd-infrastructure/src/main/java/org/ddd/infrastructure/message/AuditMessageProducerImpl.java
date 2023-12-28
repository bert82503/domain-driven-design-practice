package org.ddd.infrastructure.message;

import org.springframework.stereotype.Component;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.ddd.domain.message.AuditMessageProducer;
import org.ddd.domain.value.object.AuditMessage;

/**
 * 审计消息生产者实现
 *
 * @author guang.yi
 * @since 2023/12/28
 */
@Component("auditMessageProducer")
public class AuditMessageProducerImpl implements AuditMessageProducer {

    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";

    private final RocketMQTemplate rocketMQTemplate;

    public AuditMessageProducerImpl(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @Override
    public SendResult send(AuditMessage message) {
        String messageBody = message.serialize();
        return rocketMQTemplate.syncSend(TOPIC_AUDIT_LOG, messageBody);
    }

}
