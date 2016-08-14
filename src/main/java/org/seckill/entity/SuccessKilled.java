package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * User: xujiangjun
 * Date: 16/8/10 09:04
 * Desc: 秒杀成功明细表对应的实体类
 */
@Data
public class SuccessKilled {
    /**
     * 秒杀商品id
     */
    private Long seckillId;

    /**
     * 用户手机号
     */
    private Long userPhone;

    /**
     * 状态标识：－1:无效 0-成功 1-已付款
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /** 变通的地方：多对一 **/
    private Seckill seckill;
}
