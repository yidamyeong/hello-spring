//package com.dam.hellospring.mapper;
//
//import com.dam.hellospring.domain.Redis;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class RedisMapper {
//
//    @Qualifier("sqlSessionTemplate")
//    private final SqlSessionTemplate sqlSessionTemplate;
//
//    @Qualifier("redisTemplate")
//    private final StringRedisTemplate redisTemplate;
//
//    @Autowired
//    public RedisMapper(SqlSessionTemplate sqlSessionTemplate, StringRedisTemplate redisTemplate) {
//        this.sqlSessionTemplate = sqlSessionTemplate;
//        this.redisTemplate = redisTemplate;
//    }
//
//    public Redis getRedisData(String key) {
//        String value = (String) redisTemplate.opsForValue().get(key);
//        return new Redis(key, value);
//    }
//
//    public Redis addData(Redis redis) {
//        sqlSessionTemplate.insert("REDIS.addData", redis);
//        return sqlSessionTemplate.selectOne("REDIS.findLastAdded");
//    }
//
//    public List<Redis> findAll() {
//        return sqlSessionTemplate.selectList("REDIS.findAll");
//    }
//
//    public Redis findByKey(String key) {
//        return sqlSessionTemplate.selectOne("REDIS.findByKey", key);
//    }
//
//}
