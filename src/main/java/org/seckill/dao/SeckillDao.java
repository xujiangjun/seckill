package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * User: xujiangjun
 * Date: 16/8/10 09:11
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId 秒杀商品id
     * @param killTime  秒杀时间
     * @return 更新的行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId 秒杀商品id
     * @return 秒杀库存对象
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset  偏移量
     * @param limit   限制查询数目
     * @return 多个秒杀库存对象
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
