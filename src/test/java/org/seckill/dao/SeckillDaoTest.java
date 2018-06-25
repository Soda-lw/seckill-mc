/*
package org.seckill.dao;

import com.sun.jdi.IntegerValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.enums.Number;
import org.seckill.enums.SeckillStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

*/
/**
 * @author: liuwei
 * @Date: 21:04 2018/4/3
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() {
    }

    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill =  seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);

    }

    @Test
    public void queryAll() {
//        List<Seckill> seckillList = seckillDao.queryAll(0,100);
//        seckillList.forEach(n-> System.out.println(n));
        Calendar calendar = new GregorianCalendar();
        String showTime = "year = " + calendar.get(Calendar.YEAR) + " month = " + Integer.valueOf(calendar.get(Calendar.MONTH)+1)
                + " dayOfMonth = " + calendar.get(Calendar.DAY_OF_MONTH) + " weekOfYear = " +calendar.get(Calendar.WEEK_OF_YEAR)
                + " weekOfMonth = " + calendar.get(Calendar.WEEK_OF_YEAR) + " hour = " + calendar.get(Calendar.HOUR)
                + " hourOfDay = " + calendar.get(Calendar.HOUR_OF_DAY) + " minutes = " + calendar.get(Calendar.MINUTE)
                + " second = " + calendar.get(Calendar.SECOND) + " millsecond = " + calendar.get(Calendar.MILLISECOND);
        logger.info(showTime);
        calendar.set(Calendar.YEAR,2017);
        logger.info(String.valueOf(calendar.get(Calendar.YEAR)));
        calendar.set(2017,04,22);
        logger.info(String.valueOf(calendar.getTime()));
        System.out.println(SeckillStateEnum.SUCCESS.getState());
        System.out.println(Number.ONE.getNum());
        System.out.println(Number.ONE.getSum());
    }

}*/
