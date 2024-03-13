package org.ddd.bank;

/**
 * 有身份的实体
 *
 * @author guang.yi
 * @since 2024/2/17
 */
public interface Identifiable<ID extends Identifier> {

    /**
     * 获取实体身份
     *
     * @return 实体身份
     */
    ID getId();

}
