package org.ddd.domain.gateway;

/**
 * 对外系统的依赖通过gateway进行解耦
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public interface HealthCodeGateway {

    /**
     * 获取健康码
     *
     * @param idCardNo 身份证号码
     * @return 健康码
     */
    String getHealthCode(String idCardNo);

}
