package org.seckill.exception;

/**
 * @author: liuwei
 * @Date: 19:44 2018/4/9
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

