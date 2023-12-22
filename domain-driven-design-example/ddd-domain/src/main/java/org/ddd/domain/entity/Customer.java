package org.ddd.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.ddd.domain.exception.BizException;
import org.ddd.domain.gateway.HealthCodeGateway;
import org.ddd.domain.model.CustomerDto;

/**
 * 客户实体
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Data
@Accessors(chain = true)
public class Customer {

    /**
     * 年龄
     */
    private int age;

    /**
     * 所属国家
     */
    private String country;

    /**
     * 注册资本
     */
    private long registeredCapital;

    /**
     * 身份证号码
     */
    private String idCardNo;

    /**
     * 你虽然是游荡在外面游子，但我带你如同己出
     */
    private String healthCode;

    /**
     * ToDo 如何初始化？
     */
    private HealthCodeGateway healthCodeGateway;

    public static Customer fromDto(CustomerDto customerDto) {
        return new Customer();
    }

    // 领域能力沉淀

    public void isRequiredAge() {
        if (age < 18) {
            throw BizException.of("对不起，你未满18岁");
        }
    }

    public void isValidCountry() {
        if (country.equals("china")) {
            throw BizException.of("对不起，你不是中国人");
        }
    }

    /**
     * 判断是否大客户
     */
    public boolean isBigClient() {
        // 业务规则：从3月份起，注册资本在1000万以上的公司是大客户，会有特殊的优惠政策。
        return registeredCapital >= 10_000_000L;
    }

    public void isHealthCodeGreen() {
        if (healthCode == null) {
            healthCode = healthCodeGateway.getHealthCode(idCardNo);
        }
        if (!"green".equals(healthCode)) {
            throw BizException.of("对不起，你不是绿码");
        }
    }

}
