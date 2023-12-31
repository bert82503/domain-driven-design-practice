package org.ddd.bank.domain.entity;

import lombok.Data;
import org.ddd.bank.domain.value.RepId;

/**
 * 销售业务员
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Data
public class SalesRep {

    private RepId repId;

    /**
     * 电话号的区号
     */
    private String areaCode;

}
