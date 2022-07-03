package com.vti.controller;

import com.vti.entity.Product;
import com.vti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("list")
    public List<Product> getAll(@RequestParam("productName") String productName){
        List<Product> products= productService.getByName(productName);
        return products;
    }

    @PostMapping()
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping(value = "/{id}")
    public void updateProduct(@PathVariable(name = "id") Integer id, @RequestBody Product product) {
        product.setId(id);
        productService.update(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable(name = "id") Integer id) {
        productService.delete(id);
    }
}
