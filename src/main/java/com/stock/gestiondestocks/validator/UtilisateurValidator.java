package com.stock.gestiondestocks.validator;


import com.stock.gestiondestocks.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillee renseigner l' adresse de l'utilisateur");
            errors.add("Veuillee renseigner le prenom de l'utilisateur");
            errors.add("Veuillee renseigner l'email de l'utilisateur");
            errors.add("Veuillee renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillee renseigner la date de naissance de l'utilisateur");
            errors.add("Veuillee renseigner l' adresse de l'utilisateur");
            return  errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillee renseigner le nom de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillee renseigner le prenom de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillee renseigner l'email de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillee renseigner le mot de passe de l'utilisateur");
        }

        if(utilisateurDto.getDateDenaissance() == null){
            errors.add("Veuillee renseigner la date de naissance de l'utilisateur");
        }

        if(utilisateurDto.getAdresse() == null){
            errors.add("Veuillee renseigner l' adresse de l'utilisateur");
        } else {

            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("Le champs 'Adresse 1' est obligatoire");
            }

            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Le champs 'Code postale' est obligatoire");
            }

            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Le champs 'Pays' est obligatoire");
            }
        }

        return  errors;
    }
}
