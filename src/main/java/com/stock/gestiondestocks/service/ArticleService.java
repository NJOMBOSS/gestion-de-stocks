package com.stock.gestiondestocks.service;

import com.stock.gestiondestocks.dto.ArticleDto;
import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
