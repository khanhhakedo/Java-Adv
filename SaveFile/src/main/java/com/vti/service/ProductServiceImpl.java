package com.vti.service;

import com.vti.entity.Product;
import com.vti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByName(String productName) {
        List<Product> products = productRepository.findByProductName(productName);
        return products;
    }

//    @Override
//    public List<Product> getByProductId(Integer id) {
//        List<Product> products = productRepository.findByProductId(id);
//        return products;
//    }


    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void update(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(Integer id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);

    }
}
