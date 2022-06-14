package com.stock.gestiondestocks.validator;


import com.stock.gestiondestocks.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FounisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("Veuillee renseigner le nom du fournisseur");
            errors.add("Veuillee renseigner le prenom du fournisseur");
            errors.add("Veuillee renseigner le Mail du fournisseur");
            errors.add("Veuillee renseigner le numero de telephone du fournisseur");
            return errors;
        }

        if(!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Veuillee renseigner le nom du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Veuillee renseigner le prenom du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getMail())){
            errors.add("Veuillee renseigner le Mail du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Veuillee renseigner le numero de telephone du fournisseur");
        }

        return errors;
    }
    }
