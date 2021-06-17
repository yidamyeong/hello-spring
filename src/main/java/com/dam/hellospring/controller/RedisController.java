//package com.dam.hellospring.controller;
//
//import com.dam.hellospring.domain.Redis;
//import com.dam.hellospring.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/redis")
//public class RedisController {
//
//    private final RedisService redisService;
//
//    @Autowired
//    public RedisController(RedisService redisService) {
//        this.redisService = redisService;
//    }
//
//    @PostMapping("/data")
//    public Redis addData(String key) {
//        Redis redis = redisService.getRedisData(key);
//        return redisService.addData(redis);
//    }
//
//    @GetMapping("/data")
//    public Redis findByKey(@RequestParam(value = "key", required = false) String key) {
//        return redisService.findByKey(key);
//    }
//}
