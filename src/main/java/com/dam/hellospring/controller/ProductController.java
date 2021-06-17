package com.dam.hellospring.controller;

import com.dam.hellospring.domain.Product;
import com.dam.hellospring.domain.Redis;
import com.dam.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RestController
@RequestMapping("/api") // endPoint
public class ProductController {

    private final ProductService productService;
    private final JedisPool jedisPool;

    @Autowired
    public ProductController(ProductService productService, JedisPool jedisPool) {
        this.productService = productService;
        this.jedisPool = jedisPool;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "msg", required = false) String msg) {
        return msg;
    }

    @GetMapping("/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "상품이 삭제되었습니다.";
    }

    @PostMapping("/redis")
    public Redis insertRedisData(@RequestBody String key) {
        Jedis jedis = jedisPool.getResource();
        Redis redis = new Redis(key, jedis.get(key));

        jedis.close();

        return productService.insertRedisData(redis);
    }

}
