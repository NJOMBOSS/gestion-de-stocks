package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();

        if (entrepriseDto == null) {
            errors.add("Veuillee renseigner le nom de l'entreprise");
            errors.add("Veuillee renseigner le descriptif de l'entreprise");
            errors.add("Veuillee renseigner l'adresse l'entreprise");
            errors.add("Veuillee renseigner le code fiscal l'entreprise");
            errors.add("Veuillee renseigner le Maii de l'entreprise");
            errors.add("Veuillee renseigner le numero de téléphone de l'entreprise");
            errors.add("Veuillee renseigner le site web de l'entreprise");
            ;
            return errors;
        }


        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillee renseigner le nom de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("Veuillee renseigner le descriptif de l'entreprise");
        }

        if(entrepriseDto.getAdresse() == null){
            errors.add("Veuillee renseigner l' adresse de l'entreprise");
        } else {

            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())){
                errors.add("Le champs 'Adresse 1' est obligatoire");
            }

            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())){
                errors.add("Le champs 'Code postale' est obligatoire");
            }

            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())){
                errors.add("Le champs 'Pays' est obligatoire");
            }
        }

        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Veuillee renseigner le code fiscal de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getMail())){
            errors.add("Veuillee renseigner le Mail de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillee renseigner le numero de téléphone de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getSiteWeb())){
            errors.add("Veuillee renseigner le site web de l'entreprise");
        }

        return errors;
    }
}
