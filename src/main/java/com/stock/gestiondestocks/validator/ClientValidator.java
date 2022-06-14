package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Veuillee renseigner le nom du client");
            errors.add("Veuillee renseigner le prenom du client");
            errors.add("Veuillee renseigner le Mail du client");
            errors.add("Veuillee renseigner le numero de telephone du client");
            return  errors;
        }

        if(!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuillee renseigner le nom du client");
        }

        if(!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuillee renseigner le prenom du client");
        }

        if(!StringUtils.hasLength(clientDto.getMail())){
            errors.add("Veuillee renseigner le Mail du client");
        }

        if(!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Veuillee renseigner le numero de telephone du client");
        }
        return errors;
    }
}
