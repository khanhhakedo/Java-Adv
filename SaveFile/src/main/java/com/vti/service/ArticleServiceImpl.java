package com.vti.service;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl  implements  ArticleService{
    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getByName(String articleName) {
        List<Article> articles = articleRepository.findByArticleName(articleName);
        return articles;
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);

    }

    @Override
    public void update(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void delete(Integer id) {
        Article article = articleRepository.findById(id).get();
        articleRepository.delete(article);

    }
}
