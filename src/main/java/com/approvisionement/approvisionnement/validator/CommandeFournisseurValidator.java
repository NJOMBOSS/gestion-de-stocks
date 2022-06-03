package com.approvisionement.approvisionnement.validator;

import com.approvisionement.approvisionnement.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors = new ArrayList<>();

        if(commandeFournisseurDto == null){
            errors.add("Veuillee renseigner le code de la commande du fournisseur");
            errors.add("Veuillez renseigner la date de la commande du fournisseur");
            errors.add("Veuillez renseigner le fournisseur dans la commande");
            return errors;
        }

        if(!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("Veuillee renseigner le code de la commande du fournisseur");
        }


        if(commandeFournisseurDto.getDateCommande() == null){
            errors.add("Veuillez renseigner la date de la commande du fournisseur");
        }

        if(commandeFournisseurDto.getFournisseurDto()== null){
            errors.add("Veuillez renseigner le fournisseur dans la commande");
        }

        return errors;
    }
}
