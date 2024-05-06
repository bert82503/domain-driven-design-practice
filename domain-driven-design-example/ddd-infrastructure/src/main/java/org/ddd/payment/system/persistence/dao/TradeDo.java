package org.ddd.payment.system.persistence.dao;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 交易单【数据对象】
 *
 * @since 2024/5/6
 */
@Data
@Accessors(chain = true)
@TableName("t_trade")
public class TradeDo {
    /**
     * 交易单号
     */
    @TableId(value = "trade_id", type = IdType.AUTO)
    private Long tradeId;

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
