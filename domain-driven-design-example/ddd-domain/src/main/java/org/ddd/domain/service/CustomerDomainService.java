package org.ddd.domain.service;

import org.ddd.domain.model.CustomerDto;

/**
 * 客户领域服务
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public interface CustomerDomainService {

    /**
     * 注册客户
     *
     * @param customerDto 客户数据
     */
    void register(CustomerDto customerDto);

}
