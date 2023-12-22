package org.ddd.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 健康码请求
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Data
@Accessors(chain = true)
public class HealthCodeRequest {

    /**
     * 身份证号码
     */
    private String idCardNo;

}
