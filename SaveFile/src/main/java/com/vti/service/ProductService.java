package com.vti.service;

import com.vti.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public List<Product> getByName(String productName);
//    List<Product> getByProductId(Integer id);
    public void save(Product product);

    public void update(Product product);

    public void delete(Integer id);

//    public boolean isProductExistsById(Integer id);
//
//    public boolean isProductExistsByProductName(String productname);


}
