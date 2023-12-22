package org.ddd.domain.model;

import lombok.Data;

/**
 * TODO
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Data
public class HealthCodeResponse {

    /**
     * 状态码
     */
    private int code;

    /**
     * 健康码
     */
    private String healthCode;

    public boolean isSuccess() {
        return code == 0;
    }

}
