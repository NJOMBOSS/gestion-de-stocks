package com.stock.gestiondestocks.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    @JsonIgnore
    private ArticleDto articleDto;

    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseurDto;

    private BigDecimal quantite;

    private BigDecimal prixunitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur == null){
            return null;
        }

        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixunitaire(ligneCommandeFournisseur.getPrixunitaire())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto == null){
            return null;
        }

        LigneCommandeFournisseur l = new LigneCommandeFournisseur();
        l.setId(ligneCommandeFournisseurDto.getId());
        l.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        l.setPrixunitaire(ligneCommandeFournisseurDto.getPrixunitaire());
        return l;
    }
}
