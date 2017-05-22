package org.seckill.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:11
 */
//@Data
    @Getter
    @Setter
public class Person {

    /**
     * 性别枚举
     */
    enum Gender{
        MALE,FEMALE
    }

    /** 姓名 **/
    private String name;

    /** 年龄 **/
    private Integer age;

    /** 手机号 **/
    private String phone;

    /** 身份证号 **/
    private String ID;
}

/**
 * 颜色枚举（亦可单独成枚举类）
 */
enum Color{
    RED,YELLOW,GREEN,WHITE
}
