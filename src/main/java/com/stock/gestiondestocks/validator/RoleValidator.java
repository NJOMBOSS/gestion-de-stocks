package com.stock.gestiondestocks.validator;

import com.stock.gestiondestocks.dto.RoleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validate(RoleDto roleDto) {
        List<String> errors = new ArrayList<>();

        if(roleDto == null || !StringUtils.hasLength(roleDto.getRoleName())){
            errors.add("Veuillez renseigner le nom du rôle");
        }

        return errors;
    }

}
