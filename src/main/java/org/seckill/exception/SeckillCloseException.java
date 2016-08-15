package org.seckill.exception;

/**
 * User: xujiangjun
 * Date: 16/8/14 17:59
 * Desc: 秒杀关闭异常
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
