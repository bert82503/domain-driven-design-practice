package org.ddd.domain.service.impl;

import org.springframework.stereotype.Service;

import org.ddd.domain.entity.Customer;
import org.ddd.domain.gateway.CustomerGateway;
import org.ddd.domain.model.CustomerDto;
import org.ddd.domain.service.CustomerService;

/**
 * 客户领域服务实现
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerGateway customerGateway;

    public CustomerServiceImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public void register(CustomerDto customerDto) {
        Customer customer = Customer.fromDto(customerDto);

        // 1. 校验年龄
        customer.isRequiredAge();

        // 2. 校验国籍
        customer.isValidCountry();

        // 3. 查看健康码，需要调用另外一个服务
        customer.isHealthCodeGreen();

        // 4. 注册用户
        customerGateway.save(customer);
    }

}
