package com.dam.hellospring.dto;

import com.dam.hellospring.vo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductManager {

    private final List<Product> datas = new ArrayList<>();

    public ProductManager() {
        datas.add(new Product(1, "애플 아이폰 11 pro", 1500000));
        datas.add(new Product(2, "삼성 갤럭시 노트 10", 1400000));
        datas.add(new Product(3, "삼성 갤럭시 폴드", 2500000));
        datas.add(new Product(4, "LG G9", 1000000));
    }

    // 상품 추가
    public void addProduct(Product product) {
        product.setId(datas.size() + 1);
        datas.add(product);
    }

    // 모든 상품정보 불러오기
    public List<Product> getDatas() {
        return datas;
    }

    // id 값을 통해 해당하는 상품만 불러오기
    public Product getProduct(int id) {
        return datas.get(id - 1);
    }

    // id 값에 해당하는 상품 수정
    public Product updateProduct(int id, Product modifiedProduct) {
        Product product = getProduct(id);
        product.setName(modifiedProduct.getName());
        product.setPrice(modifiedProduct.getPrice());
        return product;
    }

    // id 값을 통해 해당하는 상품 제거
    public void delProduct(int id) {
        datas.remove(id - 1);
    }
}
