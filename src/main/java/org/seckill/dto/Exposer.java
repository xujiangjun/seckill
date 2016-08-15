package org.seckill.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: xujiangjun
 * Date: 16/8/14 17:41
 * Desc: 暴露秒杀地址DTO
 */
@Setter
@Getter
@ToString
public class Exposer {

    /**
     * 是否开启秒杀
     */
    private boolean exposed;

    /**
     * 一种加密措施
     */
    private String md5;

    /**
     * 秒杀商品id
     */
    private long seckillId;

    /**
     * 系统当前时间（毫秒）
     */
    private long now;

    /**
     * 秒杀开启时间
     */
    private long start;

    /**
     * 秒杀结束时间
     */
    private long end;

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }
}
