package com.vti.controller;



import com.vti.Dto.CategoryDto;
import com.vti.entity.Category;
import com.vti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


//    @GetMapping()
//    public List<Category> getAllCategorys() {
//        return categoryService.getAll();
//    }


    //Chuyển đổi DTO
    @GetMapping()
    public ResponseEntity<?> getAllCategorys() {
        List<Category> categories = categoryService.getAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category: categories){

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDto.setCreatedDate(category.getCreatedDate());
            categoryDto.setProducts(category.getProducts());
            categoryDto.setVideoList(category.getVideoList());

            categoryDtos.add(categoryDto);

        }
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @GetMapping("listname")
    public List<Category> getAll(@RequestParam("categoryName") String categoryName){
        List<Category> categories= categoryService.getByCategoryName(categoryName);
        return categories;
    }

    @GetMapping("listid")
    public List<Category> getAll(@RequestParam("id") Integer id){
        List<Category> categories= categoryService.getByCategoryId(id);
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
