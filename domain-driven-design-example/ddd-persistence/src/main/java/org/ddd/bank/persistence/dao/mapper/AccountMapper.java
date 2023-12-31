package org.ddd.bank.persistence.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ddd.bank.persistence.dao.data.AccountDO;

/**
 * 账户数据访问对象
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {
    // BaseMapper
}
