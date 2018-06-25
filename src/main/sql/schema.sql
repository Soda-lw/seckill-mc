# 秒杀执行存储过程
DELIMITER $$

#  --console ;转换为
# 定义存储过程
# 参数：in 输入参数，out 输出参数
# row_count():返回上一条修改类型sql的影响行数
# row_count :0:未修改数据；大于0：表示修改的行数；小于0：sql错误/未执行修改sql。
CREATE PROCEDURE `seckill`.`execute_seckill`
(in v_seckill_id bigint, in v_phone bigint,
    in v_kill_time TIMESTAMP ,out r_result int)
BEGIN
  DECLARE insert_count int DEFAULT 0;
  START TRANSACTION ;
  insert ignore into success_killed
  (seckill_id,user_phone,create_time)
  values (v_seckill_id,v_phone,v_kill_time);
  SELECT row_count() INTO insert_count;
  IF (insert_count = 0) THEN
    ROLLBACK ;
    SET r_result = -1;
    ELSEIF (insert_count < 0) THEN
    ROLLBACK ;
    SET r_result = -2;
    ELSE
    UPDATE seckill.seckill
      SET number = number-1
      WHERE seckill_id = v_seckill_id
      AND end_time > v_kill_time
      AND start_time < v_kill_time
      and number > 0;
  SELECT row_count() INTO insert_count;
  IF (insert_count = 0) THEN
    ROLLBACK ;
    SET r_result = 0;
    ELSEIF (insert_count < 0) THEN
    ROLLBACK ;
    SET r_result = -2;
    ELSE
      COMMIT ;
    SET r_result = 1;
  END IF ;
  END IF ;

END;
$$