-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
use seckill;

-- 创建秒杀库存表
-- "`"这个符号是通过esc下面的按键打出来，AUTO_INCREMENT=1000代表自增
CREATE TABLE seckill(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `start_time` datetime NOT NULL COMMENT '秒杀开启时间',
  `end_time` datetime NOT NULL COMMENT '秒杀结束时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY(seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';

-- 初始化数据(注意修改开始秒杀时间和结束秒杀时间)
INSERT INTO seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2016-08-08 00:00:00','2017-09-09 00:00:00'),
  ('500元秒杀ipad2',200,'2016-08-08 00:00:00','2017-09-09 00:00:00'),
  ('300元秒杀小米4',300,'2016-08-08 00:00:00','2017-09-09 00:00:00'),
  ('100元秒杀红米note',400,'2016-08-08 00:00:00','2017-09-09 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
  `seckill_id` bigint NOT NULL COMMENT '秒杀商品id',
  `user_phone` bigint NOT NULL COMMENT '用户手机号',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标识：－1:无效 0-成功 1-已付款',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY(seckill_id, user_phone),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '秒杀成功明细表';
