
/*
Le validator va nous permettre de pouvoir exiger les informations sur un champ.
pour cela si un champ ne comporte pas des informations, il nous revoie un message
d'erreurs que l'on aura définie

* */

package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static  List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }

}
