package com.vti.controller;



import com.vti.Dto.ArticleDto;
import com.vti.entity.Article;
import com.vti.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/article")
public class ArticleController {



    @Autowired
    private ArticleService articleService;



//    @GetMapping()
//    public List<Article> getAllArticles(){
//        return articleService.getAll();
//    }

    @GetMapping()
    public ResponseEntity<?> getAllArticles() {
        List<Article> articles= articleService.getAll();
        List<ArticleDto> articleDtos = new ArrayList<>();

            for (Article article : articles){
                ArticleDto articleDto = new ArticleDto();
                articleDto.setId(article.getId());
                articleDto.setArticleName(article.getArticleName());
                articleDto.setContent(article.getContent());
                articleDto.setCreatedDate(article.getCreatedDate());
                articleDto.setProduct(article.getProduct());

                articleDtos.add(articleDto);
        }
        return new ResponseEntity<>(articleDtos, HttpStatus.OK);

    }

    @GetMapping( "listid")
    public List<Article> getAll(@RequestParam("id")Integer id){
        List<Article> articles = articleService.getArticleById(id);
        return articles;
    }


    @GetMapping("listname")
    public List<Article> getAll(@RequestParam("articleName") String articleName){
        List<Article>articles= articleService.getByName(articleName);
        return articles;
    }

    @PostMapping()
    public void createArticle(@RequestBody Article article) {
        articleService.save(article);
    }

    @PutMapping(value = "/{id}")
    public void updateArticle(@PathVariable(name = "id") Integer id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteArticle(@PathVariable(name = "id") Integer id) {
        articleService.delete(id);
    }

}
