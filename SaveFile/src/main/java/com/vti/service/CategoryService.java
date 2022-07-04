package com.vti.service;


import com.vti.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAll();
    public List<Category> getByCategoryName(String categoryName);

    public  List<Category> getByCategoryId(Integer id);
    public void save(Category category);

    public void update(Category category);

    public void delete(Integer id);

//    public boolean isAccountExistsById(Integer id);
}
