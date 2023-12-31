package org.ddd.bank.external.impl;

import org.springframework.stereotype.Service;

import org.ddd.bank.domain.model.HealthCodeRequest;
import org.ddd.bank.domain.model.HealthCodeResponse;
import org.ddd.bank.external.HealthCodeService;

/**
 * 健康码服务实现
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Service("healthCodeService")
public class HealthCodeServiceImpl implements HealthCodeService {

    @Override
    public HealthCodeResponse check(HealthCodeRequest request) {
        return null;
    }

}
