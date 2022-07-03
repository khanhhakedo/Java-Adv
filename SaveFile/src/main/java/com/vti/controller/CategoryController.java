package com.vti.controller;


import com.vti.entity.Category;
import com.vti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping()
    public List<Category> getAllCategorys() {
        return categoryService.getAll();
    }

    @GetMapping("list")
    public List<Category> getAll(@RequestParam("categoryName") String categoryName){
        List<Category> categories= categoryService.getByCategoryName(categoryName);
        return categories;
    }

    @PostMapping()
    public void createCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping(value = "/{id}")
    public void updateCategory(@PathVariable(name = "id") Integer id, @RequestBody Category category) {
        category.setId(id);
        categoryService.update(category);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable(name = "id") Integer id) {
        categoryService.delete(id);
    }
}
