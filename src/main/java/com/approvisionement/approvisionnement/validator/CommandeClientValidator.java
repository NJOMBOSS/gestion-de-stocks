package com.approvisionement.approvisionnement.validator;

import com.approvisionement.approvisionnement.dto.CommandeClientDto;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto) {
        List<String> errors = new ArrayList<>();

        if(commandeClientDto == null){
            errors.add("Veuillee renseigner le code de la commande du client");
            errors.add("Veuillee renseigner le code de la commande du client");
            return errors;
        }

        if(!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Veuillee renseigner le code de la commande du client");
        }

        if(commandeClientDto.getDateCommande() == null){
            errors.add("Veuillee renseigner la date de la commande du client");
        }

        return errors;
    }
}

