package org.ddd.repository;

import org.ddd.domain.entity.SalesRep;

/**
 * 销售业务员仓储
 *
 * @author guang.yi
 * @since 2023/12/23
 */
public interface SalesRepRepository {

    /**
     * 通过电话号的区号查找销售业务员
     *
     * @param areaCode 电话号的区号
     * @return 销售业务员
     */
    SalesRep findRep(String areaCode);

}
