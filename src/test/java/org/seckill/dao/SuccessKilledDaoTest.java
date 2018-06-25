/*
package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


*/
/**
 * @author: liuwei
 * @Date: 13:41 2018/4/4
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() {
        long id = 1001L;
        long userPhone = 15871708161L;
        int count =successKilledDao.insertSuccessKilled(id,userPhone);
        System.out.println("count="+count);


    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000L;
        long userPhone = 15871708161L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}*/
