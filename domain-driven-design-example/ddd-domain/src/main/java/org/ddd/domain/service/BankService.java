package org.ddd.domain.service;

import org.ddd.domain.value.object.Money;

/**
 * 银行领域服务
 *
 * @author guang.yi
 * @since 2023/12/24
 */
public interface BankService {

    /**
     * A账户转账给账户 B
     *
     * @param money       钱
     * @param recipientId 接受者身份
     */
    void transfer(Money money, Long recipientId);

}
