package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

  /*  @Query("select a from article where codearticle = :code and designation =: designation")
    List<Article> findByCustomQuery(@Param("code") String c, @Param("designation") String d);

    @Query(value = "select * form artcilce where code =: cide ", nativeQuery = true)
    List<Article> findByCustomNativeQuery(@Param("code") String c);

    // IgnoreCase va nous permettre de ne pas gérer la casse lorsqu'on entre le code le l'article ou sa désignation
    List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);*/

    Optional<Article> findArticleByCodeArticle(String codeArticle);
}
