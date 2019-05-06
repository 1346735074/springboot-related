package com.example.service.service.impl;

import com.example.service.service.ISeckillDistributedService;
import com.example.service.utils.RedissLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @auther: YAO
 * @date: 2018/11/5 15:59
 * @description:
 */
@Service
@Slf4j
public class SeckillDistributedServiceImpl implements ISeckillDistributedService {

    //模拟库存
    public static Integer i = new Integer(10);
    //已经卖出去的
    public static Integer ii = new Integer(0);

    @Override
    @Transactional
    public Object startRedisLock(long seckillId) {
        boolean b = false;
        try {
            //获取radis锁
            b = RedissLockUtil.tryLock(seckillId + "", TimeUnit.SECONDS, 3, 20);
            if (b){
                if (i>0){
                    i--;
                    ii++;
                    log.info("秒杀成功-库存剩余：{}",i);
                    return "秒杀成功-库存剩余："+i;
                }else {
                    log.info("秒杀完毕-库存剩余：{}",i);
                    return "秒杀完毕-库存剩余："+i;
                }
            }else {
                log.info("哎呦喂，人也太多了，请稍后！");
                return "哎呦喂，人也太多了，请稍后！";
            }
        } catch (Exception e) {
            log.error("服务器拥挤:e={}",e);
            return "服务器拥挤";
        } finally {
            if (b){
                RedissLockUtil.unlock(seckillId+"");
            }
        }
    }
}
