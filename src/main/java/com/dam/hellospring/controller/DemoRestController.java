package com.dam.hellospring.controller;

import com.dam.hellospring.dto.ProductManager;
import com.dam.hellospring.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // endpoint
public class DemoRestController {

    private final ProductManager productManager;

    @Autowired
    public DemoRestController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value =
            "msg", required = false) String msg) {
        return msg;
    }

    @GetMapping("/product")
    public List<Product> getAll() {
        return productManager.getDatas();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return productManager.getDatas().get(id - 1);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        productManager.addProduct(product);
        return "상품 추가 완료";
    }

    @PutMapping("/product/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        productManager.updateProduct(id, product);
        return "상품 수정 완료";
    }

    @DeleteMapping("/product/{id}")
    public String delProduct(@PathVariable int id) {
        productManager.delProduct(id);
        return "상품이 삭제되었습니다.";
    }
}
