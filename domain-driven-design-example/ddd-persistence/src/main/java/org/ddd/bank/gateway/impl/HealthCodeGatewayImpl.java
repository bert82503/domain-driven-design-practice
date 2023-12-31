package org.ddd.bank.gateway.impl;

import org.springframework.stereotype.Component;

import org.ddd.bank.exception.BizException;
import org.ddd.bank.gateway.HealthCodeGateway;
import org.ddd.bank.domain.model.HealthCodeRequest;
import org.ddd.bank.domain.model.HealthCodeResponse;
import org.ddd.bank.external.HealthCodeService;

/**
 * 把如何获取HealthCode这样的技术细节问题丢给infrastructure去处理
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Component("healthCodeGateway")
public class HealthCodeGatewayImpl implements HealthCodeGateway {

    private final HealthCodeService healthCodeService;

    public HealthCodeGatewayImpl(
            HealthCodeService healthCodeService
    ) {
        this.healthCodeService = healthCodeService;
    }

    @Override
    public String getHealthCode(String idCardNo) {
        HealthCodeRequest request = new HealthCodeRequest()
                .setIdCardNo(idCardNo);
        HealthCodeResponse response = healthCodeService.check(request);
        if (!response.isSuccess()) {
            throw BizException.of("无法验证健康码，请稍后再试");
        }
        return response.getHealthCode();
    }

}
