package com.luolei.novel.sys.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;



    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }


}
