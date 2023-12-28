package org.ddd.domain.service.impl;

import java.math.BigDecimal;

import org.ddd.domain.model.Result;
import org.ddd.domain.service.TransferService;

/**
 * 转账服务实现
 *
 * @author guang.yi
 * @since 2023/12/26
 */
public class TransferServiceImpl implements TransferService {

    @Override
    public Result<Boolean> transfer(
            Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        return null;
    }

}
