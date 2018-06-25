package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author: liuwei
 * @Date: 16:20 2018/3/30
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @Date:16:25 2018/3/30
     *
     *
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据ID查询successKilled并携带秒杀产品对象实体
     * @Date:16:26 2018/3/30
     *
     *
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
