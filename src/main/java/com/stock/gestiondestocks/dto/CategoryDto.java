package com.stock.gestiondestocks.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private  String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articleDto;

    //Nous allons écire une méthode pour gérer les catégorie; donc le mapping

    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            // TODO throw an exception
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
            // TODO throw an exception
        }

        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
