package org.ddd.application.controller;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RestController;

import org.ddd.domain.model.Result;
import org.ddd.domain.service.TransferService;

/**
 * 转账控制器
 *
 * @author guang.yi
 * @since 2023/12/26
 */
@RestController("transferController")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    public Result<Boolean> transfer(
            String targetAccountNumber, BigDecimal amount, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }

}
