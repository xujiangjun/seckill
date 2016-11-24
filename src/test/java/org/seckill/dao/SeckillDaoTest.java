package org.seckill.dao;

import com.google.common.base.Splitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: xujiangjun
 * Date: 16/8/14 16:00
 * SeckillDao单元测试，可通过在SeckillDao上按Alt + Enter快捷键，点击Create Test快速创建
 * 配置Spring和Junit整合，为了使Junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000l, killTime);
        System.out.println("updateCount = " + updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        long id = 1000l;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    /**
     * Java没有保存形参的记录，故需要加上@Param进行参数绑定
     * @throws Exception
     */
    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

    @Test
    public void testGetOrderFlags(){
        List<String> fullList = new ArrayList<>();
        List<String> str1List = seckillDao.getOrderFlags("flags", "orderflags1");
        List<String> str2List = seckillDao.getOrderFlags("field1", "orderflags2");
        List<String> str3List = seckillDao.getOrderFlags("field1", "orderflags3");
        fullList.addAll(str1List);
        fullList.addAll(str2List);
        fullList.addAll(str3List);
        List<String> allList = new ArrayList<>();
        for (String s : fullList) {
            List<String> strList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(s);
            for (String s1 : strList) {
                if(allList.contains(s1)){
                    break;
                }else{
                    allList.add(s1);
                }
            }
        }
        System.out.println(allList);
    }

    @Test
    public void testf(){
        //Assert.assertEquals();
    }
}