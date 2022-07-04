package com.vti.controller;


import com.vti.Dto.ProductDto;
import com.vti.entity.Product;
import com.vti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping()
//    public List<Product> getAllProducts() {
//        return productService.getAll();
//    }

    @GetMapping("listname")
    public List<Product> getAll(@RequestParam("productName") String productName){
        List<Product> products= productService.getByName(productName);
        return products;
    }

    @GetMapping("listid")
    public List<Product> getAll(@RequestParam("id") Integer id){
        List<Product> products= productService.getByProductId(id);
        return products;
    }

    //Chuyển đổi DTO
    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setProductName(product.getProductName());
            productDto.setPrice(product.getPrice());
            productDto.setType(product.getType());
            productDto.setCategory(product.getCategory());
            productDto.setAccounts(product.getAccounts());

            productDtos.add(productDto);

        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
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
