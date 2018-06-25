package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: liuwei
 * @Date: 21:58 2018/6/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestRedisDao  {
    long id = 1001;
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testSeckill() throws Exception{
       Seckill seckill = redisDao.getSeckill(id);
       if(seckill == null) {
           seckill = seckillDao.queryById(id);
           if(seckill != null){
               String result = redisDao.putSeckill(seckill);
               System.out.println(result);
               seckill = redisDao.getSeckill(id);
               System.out.println("通过redis获取数据："+seckill);
           }

       }


        
    }

}
