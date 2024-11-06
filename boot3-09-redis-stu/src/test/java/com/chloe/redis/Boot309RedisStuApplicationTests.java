package com.chloe.redis;

import com.chloe.redis.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

@SpringBootTest
@Slf4j
class Boot309RedisStuApplicationTests {
    /**
     * 测试Redis的
     * String
     * List
     * Hash
     * Set
     * Zset
     * 其他的数据结构这里就不试了
     */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
        String stringKey = "stringTest";
        stringRedisTemplate.opsForValue().set(stringKey, "v1");
        String stringVal = stringRedisTemplate.opsForValue().get(stringKey);
        log.info("string key: {}, value: {}",  stringKey, stringVal);
    }

    @Test
    public void testList(){
        String listKey = "listKey";
        stringRedisTemplate.opsForList().leftPushAll(listKey,String.valueOf(1), String.valueOf(2));
        String value = stringRedisTemplate.opsForList().leftPop(listKey);
        log.info("取出的数据是：{}", value);
        Assertions.assertEquals(String.valueOf(2), value);
    }


    @Test
    public void testHash(){
        String hashKey = "hashKey";
        stringRedisTemplate.opsForHash().put(hashKey, "name", "张三");
        stringRedisTemplate.opsForHash().put(hashKey, "age", "18");

        Object name = stringRedisTemplate.opsForHash().get(hashKey, "name");
        Assertions.assertEquals("张三", name);
    }
    
    @Test
    public void testSet(){
        String setKey = "setKey";
        Long add = stringRedisTemplate.opsForSet().add(setKey, "z3", "li4", "w5", "w5");
        Assertions.assertEquals(3, add);
    }

    @Test
    public void testZset(){
        String zsetKey = "zsetKey";
        stringRedisTemplate.opsForZSet().add(zsetKey, "z3", 90.00);
        stringRedisTemplate.opsForZSet().add(zsetKey, "li4", 101.00);
        stringRedisTemplate.opsForZSet().add(zsetKey, "z3", 90.20);

        ZSetOperations.TypedTuple<String> stringTypedTuple = stringRedisTemplate.opsForZSet().popMax(zsetKey);
        String value = stringTypedTuple.getValue();
        Double score = stringTypedTuple.getScore();
        log.info("max score info => value: {} , score: {}", value, score);
    }

    /**
     * 序列化对象
     */
    @Test
    public void testPerson(){
        redisTemplate.opsForValue().set("person", new Person(1L, "张三", 20));
    }
    
    @Test
    public void testJedis(){
        redisTemplate.opsForValue().set("p1", new Person(2L, "李四", 32));
    }
}
