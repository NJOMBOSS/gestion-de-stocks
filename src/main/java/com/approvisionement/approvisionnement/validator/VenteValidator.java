package com.approvisionement.approvisionnement.validator;

import com.approvisionement.approvisionnement.dto.VenteDto;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto venteDto) {
        List<String> errors = new ArrayList<>();

        if(venteDto == null){
            errors.add("Veuillez entrer le code la vente");
            errors.add("Veuillez renseigner la date de vente");
            errors.add("Veuillez entrer un commentaire");
        }

        if(!StringUtils.hasLength(venteDto.getCode())){
            errors.add("Veuillez entrer le code la vente");
        }

            if(venteDto.getDatevente() == null){
            errors.add("Veuillez renseigner la date de vente");
        }

        if(!StringUtils.hasLength(venteDto.getCommentaire())){
            errors.add("Veuillez entrer un commentaire");
        }
        return errors;
    }

    }
