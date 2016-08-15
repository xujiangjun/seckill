package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * User: xujiangjun
 * Date: 16/8/14 17:53
 * Desc: 封装秒杀执行后结果
 */
@Setter
@Getter
@ToString
public class SeckillExecution {

    /**
     * 秒杀商品id
     */
    private long seckillId;

    /**
     * 秒杀执行结果状态
     */
    private int state;

    /**
     * 状态标识(可以使用枚举类)
     */
    private String stateInfo;

    /**
     * 秒杀成功对象
     */
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }
}
