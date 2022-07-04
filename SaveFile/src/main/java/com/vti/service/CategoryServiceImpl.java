package com.vti.service;

import com.vti.entity.Category;
import com.vti.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getByCategoryName(String categoryName) {
        List<Category> categories = categoryRepository.findByCategoryName(categoryName);
        return categories;
    }

    @Override
    public List<Category> getByCategoryId(Integer id) {
        List<Category> categories = categoryRepository.getCategoryById(id);
        return categories;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);

    }
}
