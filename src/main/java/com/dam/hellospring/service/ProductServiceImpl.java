package com.dam.hellospring.service;

import com.dam.hellospring.domain.Product;
import com.dam.hellospring.domain.Redis;
import com.dam.hellospring.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(int id) {
        return productMapper.findById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }

    @Override
    public Redis insertRedisData(Redis redis) {
        return productMapper.insertRedisData(redis);
    }
}
