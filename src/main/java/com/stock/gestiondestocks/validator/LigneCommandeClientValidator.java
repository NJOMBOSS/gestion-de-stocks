package com.stock.gestiondestocks.validator;



import com.stock.gestiondestocks.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();

        if(ligneCommandeClientDto == null){
            errors.add("Veuillez renseigner la commande du client");
            errors.add("Veuillez renseigner la quantite de la commande du client");
            errors.add("Veuillez renseigner le prix unitaire du commande du client");

            return errors;
        }

        if(ligneCommandeClientDto.getCommandeClientDto() == null){
            errors.add("Veuillez renseigner la commande du client");
        }

        if(ligneCommandeClientDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite de la commande du client");
        }

        if(ligneCommandeClientDto.getPrixunitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire du commande du client");
        }

        return errors;

    }
}
