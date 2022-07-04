package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getAll();
    public List<Article> getByName(String articleName);

    public List<Article> getArticleById(Integer id);
    public void save(Article article);

    public void update(Article article);

    public void delete(Integer id);

//    public boolean isArticleExistsById(Integer id);
//
//    public boolean isArticleExistsByArticleName(String articlename);
}
