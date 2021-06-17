//package com.dam.hellospring.service;
//
//import com.dam.hellospring.domain.Redis;
//import com.dam.hellospring.mapper.RedisMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RedisService {
//
//    private final RedisMapper redisMapper;
//
//    @Autowired
//    public RedisService(RedisMapper redisMapper) {
//        this.redisMapper = redisMapper;
//    }
//
//    public Redis getRedisData(String key) {
//        return redisMapper.getRedisData(key);
//    }
//
//    public Redis addData(Redis redis) {
//        return redisMapper.addData(redis);
//    }
//
//    public List<Redis> findAll() {
//        return redisMapper.findAll();
//    }
//
//    public Redis findByKey(String key) {
//        return redisMapper.findByKey(key);
//    }
//}
