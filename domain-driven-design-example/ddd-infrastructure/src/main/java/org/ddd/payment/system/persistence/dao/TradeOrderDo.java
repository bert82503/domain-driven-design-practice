package org.ddd.payment.system.persistence.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Currency;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 交易主单【数据对象】
 *
 * @since 2024/5/6
 */
@Data
@Accessors(chain = true)
@TableName("t_trade_order")
public class TradeOrderDo {
    /**
     * 交易主单号
     */
    @TableId(value = "trade_order_id", type = IdType.AUTO)
    private Long tradeOrderId;

    /**
     * 交易单号
     *
     * @see TradeDo#getTradeId()
     */
    @TableField(value = "trade_id")
    private Long tradeId;

    /**
     * 商户订单号
     * <pre>
     * 商户订单表ID
     * </pre>
     *
     * @see MerchantOrderDo#getMerchantRequestOrderId()
     */
    @TableField(value = "merchant_order_id")
    private Long merchantOrderId;

    /**
     * 交易金额
     */
    @TableField(value = "trade_amount")
    private BigDecimal tradeAmount;

    /**
     * 交易币种
     */
    @TableField(value = "trade_currency")
    private Currency tradeCurrency;

    /**
     * 状态
     */
    @TableField(value = "trade_order_status")
    private Integer tradeOrderStatus;

    /**
     * 支付单列表
     *
     * @see PaymentOrderDo
     */
    @TableField(value = "payment_order_id_collection")
    private Collection<Long> paymentOrderIdCollection;

    /**
     * 退款单列表
     *
     * @see RefundOrderDo
     */
    @TableField(value = "refund_order_id_collection")
    private Collection<Long> refundOrderIdCollection;

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
