package org.ddd.bank.domain.value;

import lombok.Getter;
import org.ddd.bank.exception.ValidationException;

/**
 * 业务员身份【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class RepId {

    private final Long repId;

    public RepId(Long repId) {
        if (repId == null) {
            throw new ValidationException("repId不能为空");
        } else if (repId > 0L) {
            throw new ValidationException("repId是正整数");
        }
        this.repId = repId;
    }

}
