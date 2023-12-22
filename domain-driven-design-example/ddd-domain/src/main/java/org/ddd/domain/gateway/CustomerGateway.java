package org.ddd.domain.gateway;

import org.ddd.domain.entity.Customer;

/**
 * 客户服务网关
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public interface CustomerGateway {

    /**
     * 保存客户
     *
     * @param customer 客户领域实体
     * @return 操作结果
     */
    boolean save(Customer customer);

}
