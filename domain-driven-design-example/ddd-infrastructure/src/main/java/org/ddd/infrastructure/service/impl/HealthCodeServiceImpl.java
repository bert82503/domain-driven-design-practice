package org.ddd.infrastructure.service.impl;

import org.springframework.stereotype.Service;

import org.ddd.domain.model.HealthCodeRequest;
import org.ddd.domain.model.HealthCodeResponse;
import org.ddd.infrastructure.service.HealthCodeService;

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
