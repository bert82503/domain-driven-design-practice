package org.ddd.application.service;

import java.math.BigDecimal;

import org.ddd.domain.model.Result;

/**
 * 转账应用服务
 * <p>
 * 组件编排
 * 这种仅包含Orchestration（编排）的服务叫做Application Service（应用服务）。
 *
 * @author guang.yi
 * @since 2023/12/26
 */
public interface TransferService {

    /**
     * 用户可以转账给另一个账号，支持跨币种转账。
     *
     * @param sourceUserId        来源用户身份
     * @param targetAccountNumber 目标账号
     * @param targetAmount        目标金额
     * @param targetCurrency      目标币种
     * @return 转账结果
     */
    Result<Boolean> transfer(
            Long sourceUserId, String targetAccountNumber,
            BigDecimal targetAmount, String targetCurrency);

}
