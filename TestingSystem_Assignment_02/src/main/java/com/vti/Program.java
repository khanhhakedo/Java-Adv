package com.vti;

import com.vti.entity.Article1;
import com.vti.entity.Article2;
import com.vti.repository.ArticleRepository;
import com.vti.repository.ArticleRepository2;

import java.util.Date;

public class Program {
	public static void main(String[] args) {
		ArticleRepository repository1 = new ArticleRepository();


		Article1 article1 = new Article1();
		article1.setTitle("Article 2");
		article1.setStatus(Article1.Status.REVIEW);
		article1.setCreatedDate(new Date());
		repository1.createArticle1(article1);

		ArticleRepository2 repository2 = new ArticleRepository2();


		Article2.ArticlePk pk = new Article2.ArticlePk();
		pk.setOrderId((short) 1);
		pk.setProductId((short)2);

		Article2 article2 = new Article2();
		article2.setId(pk);
		article2.setTitle("Test 1");
		article2.setCreatedDate(new Date());

		repository2.createArticle2(article2);
	}
}

