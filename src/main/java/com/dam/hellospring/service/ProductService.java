package com.dam.hellospring.service;

import com.dam.hellospring.domain.Product;
import com.dam.hellospring.domain.Redis;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    List<Product> findAll();

    Product findById(int id);

    Product updateProduct(Product product);

    void deleteProduct(int id);

    Redis insertRedisData(Redis redis);
}
