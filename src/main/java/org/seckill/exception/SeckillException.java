package org.seckill.exception;

/**
 * User: xujiangjun
 * Date: 16/8/14 18:00
 * Desc: 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
