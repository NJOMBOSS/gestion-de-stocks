package com.approvisionement.approvisionnement.validator;

import com.approvisionement.approvisionnement.dto.LigneCommandeFournisseurDto;
import com.approvisionement.approvisionnement.dto.RoleDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        List<String> errors = new ArrayList<>();

        if(ligneCommandeFournisseurDto == null){
            errors.add("Veuillez renseigner l'article dans la commande du fournisseur");
            errors.add("Veuillez renseigner  la commande du fournisseur'");
            errors.add("Veuillez renseigner la quantite dans la commande du fournisseur");
            errors.add("Veuillez renseigner le prix unitaire dans la commande du fournisseur");

            return errors;
        }

        if(ligneCommandeFournisseurDto.getArticleDto() == null){
            errors.add("Veuillez renseigner l'article dans la commande du fournisseur");
        }

        if(ligneCommandeFournisseurDto.getCommandeFournisseurDto() == null){
            errors.add("Veuillez renseigner  la commande du fournisseur'");
        }

        if(ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantite dans la commande du fournisseur");
        }

        if(ligneCommandeFournisseurDto.getPrixunitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire dans la commande du fournisseur");
        }

        return errors;
    }
}
