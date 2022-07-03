package com.vti.repository;

import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findByProductName (String productName);
//  List<Product> findByProductId (Integer id);



//    public boolean isProductExistsById(Integer id);
//
//    public boolean isProductExistsByProductName(String productname);
}
