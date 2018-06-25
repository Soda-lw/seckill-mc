package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * @author: liuwei
 * @Date: 14:12 2018/4/4
 */

public interface SeckillService {
    /**查询秒杀记录
     * @Date:14:16 2018/4/4
     *@param
     * @return
     *
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @Date:14:16 2018/4/4
     *
     *
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址
     * @Date:14:17 2018/4/4
     *
     *
     */
     Exposer exportSeckillUrl(long seckillId);

     /**
      * 执行秒杀操作
      * @Date:19:35 2018/4/9
      *
      *
      */
     SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
     throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * 执行秒杀操作 by存储过程
     * @Date:19:35 2018/4/9
     *
     *
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;
}
