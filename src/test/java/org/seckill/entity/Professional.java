package org.seckill.entity;

import lombok.Data;
import lombok.ToString;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:23
 */
@Data
@ToString(callSuper = true)
public class Professional extends Person {

    /** 教师编号 **/
    private String teacherNo;

    /** 班级 **/
    private String classNo;
}
