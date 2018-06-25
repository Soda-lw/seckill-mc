package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: liuwei
 * @Date: 16:16 2018/3/30
 */
public interface SeckillDao {
    /**
     * 减库存
     * @Date:16:16 2018/3/30
     *@param seckillId
     * @param killTime
     * @return
     *
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *根据ID查询
     * @Date:16:17 2018/3/30
     *
     *
     */
    Seckill queryById(long seckillId);


    /**
     * 根据偏移量查询
     * @Date:16:19 2018/3/30
     *
     *
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     * @Date:09:39 2018/6/12
     *
     *
     */
    void killByProcedure(Map<String,Object> paramMap);


}
