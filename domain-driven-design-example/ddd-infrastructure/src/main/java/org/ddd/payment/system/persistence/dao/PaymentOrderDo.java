package org.ddd.payment.system.persistence.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 普通支付单【数据对象】
 *
 * @since 2024/5/6
 */
@Data
@Accessors(chain = true)
@TableName("t_payment_order")
public class PaymentOrderDo {
    /**
     * 支付单号
     */
    @TableId(value = "payment_order_id", type = IdType.AUTO)
    private Long paymentOrderId;

    /**
     * 交易单号
     *
     * @see TradeDo#getTradeId()
     */
    @TableField(value = "trade_id")
    private Long tradeId;

    /**
     * 支付类型
     */
    @TableField(value = "payment_type")
    private Integer paymentType;

    /**
     * 支付金额
     */
    @TableField(value = "payment_amount")
    private BigDecimal paymentAmount;

    /**
     * 支付币种
     */
    @TableField(value = "payment_currency")
    private Currency paymentCurrency;

    /**
     * 支付单状态
     */
    @TableField(value = "payment_order_status")
    private Integer paymentOrderStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
