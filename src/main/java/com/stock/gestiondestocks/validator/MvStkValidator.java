package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.MvStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvStkValidator {

    public static List<String> validate(MvStkDto mvStkDto) {
        List<String> errors = new ArrayList<>();

        if(mvStkDto == null){
            errors.add("Veuillez renseigner la quantite du mouvement en stock");
            errors.add("Veuillez renseigner la date du mouvement en  stock");
            errors.add("Veuillez renseigner l'article' du mouvement en  stock");
            return errors;
        }

        if(mvStkDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite du mouvement en stock");
        }

        if(mvStkDto.getDateMvt() == null){
            errors.add("Veuillez renseigner la date du mouvement en  stock");
        }

        if(mvStkDto.getArticleDto() == null){
            errors.add("Veuillez renseigner l'article' du mouvement en  stock");
        }

            return errors;
    }
}
