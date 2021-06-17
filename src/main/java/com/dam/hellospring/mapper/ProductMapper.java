package com.dam.hellospring.mapper;

import com.dam.hellospring.domain.Product;
import com.dam.hellospring.domain.Redis;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductMapper {

    @Qualifier("sqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public ProductMapper(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Product> findAll() {
        return sqlSessionTemplate.selectList("PRODUCT.findAll");
    }

    public Product findById(int id) {
        return sqlSessionTemplate.selectOne("PRODUCT.findById", id);
    }

    public Product addProduct(Product product) {
        sqlSessionTemplate.insert("PRODUCT.addProduct", product);
        return sqlSessionTemplate.selectOne("PRODUCT.findLastAdded");
    }

    public Product updateProduct(Product product) {
        sqlSessionTemplate.update("PRODUCT.updateProduct", product);
        return findById(product.getId());
    }

    public void deleteProduct(int id) {
        sqlSessionTemplate.delete("PRODUCT.deleteProduct", id);
    }


    // redis data postgreSQL 넣기
    public Redis insertRedisData(Redis redis) {
        sqlSessionTemplate.insert("REDIS.addData", redis);
        Redis result = sqlSessionTemplate.selectOne("REDIS.findLastAdded");
        System.out.println("**** result: " + result);
        return result;
    }
}
