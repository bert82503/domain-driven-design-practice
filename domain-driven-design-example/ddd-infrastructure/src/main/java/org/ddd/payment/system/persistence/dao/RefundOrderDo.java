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
 * 退款单【数据对象】
 *
 * @since 2024/5/6
 */
@Data
@Accessors(chain = true)
@TableName("t_refund_order")
public class RefundOrderDo {
    /**
     * 退款单号
     */
    @TableId(value = "refund_order_id", type = IdType.AUTO)
    private Long refundOrderId;

    /**
     * 交易单号
     *
     * @see TradeDo#getTradeId()
     */
    @TableField(value = "trade_id")
    private Long tradeId;

    /**
     * 退款金额
     */
    @TableField(value = "refund_amount")
    private BigDecimal refundAmount;

    /**
     * 退款币种
     */
    @TableField(value = "refund_currency")
    private Currency refundCurrency;

    /**
     * 退款单状态
     */
    @TableField(value = "refund_order_status")
    private Integer refundOrderStatus;

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
