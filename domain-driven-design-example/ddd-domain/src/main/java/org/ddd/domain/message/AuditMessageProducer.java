package org.ddd.domain.message;

import org.apache.rocketmq.client.producer.SendResult;
import org.ddd.domain.value.object.AuditMessage;

/**
 * 审计消息生产者
 *
 * @author guang.yi
 * @since 2023/12/28
 */
public interface AuditMessageProducer {

    /**
     * 发送审计消息
     *
     * @param message 审计消息
     * @return 发送结果
     */
    SendResult send(AuditMessage message);

}
