package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * User: xujiangjun
 * Date: 16/8/10 09:13
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckillId  秒杀商品id
     * @param userPhone  用户手机号
     * @return  新增一条秒杀记录
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带Seckill对象
     * @param seckillId  秒杀商品id
     * @return  秒杀成功明细
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,
                                       @Param("userPhone") long userPhone);
}
