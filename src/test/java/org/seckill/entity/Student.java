package org.seckill.entity;

import lombok.Data;
import lombok.ToString;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:15
 */
@Data
@ToString(callSuper = true)
public class Student extends Person{

    /** 学号 **/
    private String stuNo;

    /** 班号 **/
    private String classNo;

    /** 班主任 **/
    private String teacher;

    /** 学校 **/
    private String school;

    /** 测试字段：注意get/set方法名 **/
    private String cName;

}
