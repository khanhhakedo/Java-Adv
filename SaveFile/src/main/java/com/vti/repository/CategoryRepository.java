package com.vti.repository;


import com.vti.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryName(String categoryName);

//    public boolean isAccountExistsById(Integer id);


}
