package org.ddd.domain.gateway.impl;

import org.ddd.domain.entity.Customer;
import org.ddd.domain.gateway.CustomerGateway;

/**
 * 客户服务网关实现
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public class CustomerGatewayImpl implements CustomerGateway {

    @Override
    public boolean save(Customer customer) {
        // 使用
        if (customer.isBigClient()) {
            // do something
        }
        return true;
    }

}
