package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto){
        List<String> errors =new ArrayList<>();

        if(articleDto == null){
            errors.add("Veuillee renseigner le code de l'article");
            errors.add("Veuillee renseigner la designation de l'article");
            errors.add("Veuillee renseigner le prix unitaire de l'article");
            errors.add("Veuillee renseigner le taux TVA de l'article");
            errors.add("Veuillee renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillee selectionner une categorie");
            return  errors;
        }

        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillee renseigner le code de l'article");
        }

        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillee renseigner la designation de l'article");
        }

        if(articleDto.getPrixUnitaireHt()==null){
            errors.add("Veuillee renseigner le prix unitaire de l'article");
        }

        if(articleDto.getTauxTva()==null){
            errors.add("Veuillee renseigner le taux TVA de l'article");
        }

        if(articleDto.getPrixUnitaireTtc()==null){
            errors.add("Veuillee renseigner le prix unitaire TTC de l'article");
        }
        if(articleDto.getCategoryDto()==null){
            errors.add("Veuillee selectionner une categorie");
        }

        return errors;
    }
}
