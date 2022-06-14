package com.stock.gestiondestocks.validator;


import com.stock.gestiondestocks.dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto) {
        List<String> errors = new ArrayList<>();

        if(ligneVenteDto == null){
            errors.add("Veuillez renseigner  la vente");
            errors.add("Veuillez renseigner la quantite vendu");
            errors.add("Veuillez renseigner le prix unitaire dans la vente");

            return errors;
        }


        if(ligneVenteDto.getVenteDto() == null){
            errors.add("Veuillez renseigner  la vente");
        }

        if(ligneVenteDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite vendu");
        }

        if(ligneVenteDto.getPrixunitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire dans la vente");
        }


        return errors;
    }

    }
