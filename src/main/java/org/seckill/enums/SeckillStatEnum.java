package org.seckill.enums;

import lombok.Getter;

/**
 * User: xujiangjun
 * Date: 16/8/14 23:22
 * Desc:
 */
public enum SeckillStatEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    @Getter
    private int state;

    @Getter
    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static SeckillStatEnum stateOf(int index){
        for(SeckillStatEnum item : values()){
            if(item.getState() == index){
                return item;
            }
        }
        return null;
    }
}
