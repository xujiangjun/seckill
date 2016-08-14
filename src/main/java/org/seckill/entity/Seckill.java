package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * User: xujiangjun
 * Date: 16/8/10 09:02
 * Desc: 秒杀库存表对应的实体类
 */
@Data
public class Seckill {

    /**
     * 商品库存id
     */
    private Long seckillId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存数量
     */
    private Integer number;

    /**
     * 秒杀开启时间
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createTime;
}
