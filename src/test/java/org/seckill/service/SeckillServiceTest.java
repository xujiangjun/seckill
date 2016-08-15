package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: xujiangjun
 * Date: 16/8/15 13:10
 * Desc: 快速创建测试类快捷键：Shift + Command + T 或Alt + Enter
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list = {}", list);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1000l;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill = {}", seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1000l;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer = {}", exposer);
    }

    /**
     * 集成测试代码完整逻辑，可重复执行
     * @throws Exception
     */
    @Test
    public void testExportSeckillLogic() throws Exception {
        long id = 1000l;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer = {}", exposer);
            long phone = 18770059115l;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result = {}", execution);
            } catch (SeckillCloseException e) {
                logger.error("SeckillCloseException", e);
            } catch (RepeatKillException e) {
                logger.error("RepeatKillException", e);
            }
        }else{
            logger.warn("exposer = {}", exposer);
        }
    }
}