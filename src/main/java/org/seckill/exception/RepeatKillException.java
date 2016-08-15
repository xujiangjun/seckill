package org.seckill.exception;

/**
 * User: xujiangjun
 * Date: 16/8/14 17:57
 * Desc: 重复秒杀异常
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
