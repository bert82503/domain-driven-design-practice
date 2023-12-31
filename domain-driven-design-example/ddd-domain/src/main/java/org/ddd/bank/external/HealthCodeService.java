package org.ddd.bank.external;

import org.ddd.bank.domain.model.HealthCodeRequest;
import org.ddd.bank.domain.model.HealthCodeResponse;

/**
 * 健康码服务
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public interface HealthCodeService {

    /**
     * 验证健康码
     *
     * @param request 业务请求对象
     * @return 操作结果
     */
    HealthCodeResponse check(HealthCodeRequest request);

}
