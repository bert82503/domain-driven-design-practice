package org.ddd.bank;

/**
 * 聚合根的Marker接口
 *
 * @author guang.yi
 * @since 2024/2/17
 */
public interface Aggregate<ID extends Identifier> extends Entity<ID> {
    //
}
