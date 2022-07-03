package com.vti.repository;

import com.vti.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByArticleName (String articleName);

//    public boolean isArticleExistsById(Integer id);
//
//    public boolean isArticleExistsByArticleName(String articlename);
}
