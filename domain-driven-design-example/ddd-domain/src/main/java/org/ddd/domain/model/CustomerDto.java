package org.ddd.domain.model;

import lombok.Data;

/**
 * 客户的数据传输对象
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Data
public class CustomerDto {

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

}
