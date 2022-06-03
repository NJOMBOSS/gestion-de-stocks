package com.approvisionement.approvisionnement.dto;

import com.approvisionement.approvisionnement.entity.LigneVente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    @JsonIgnore
    private VenteDto venteDto;

    private BigDecimal quantite;

    private BigDecimal prixunitaire;

    public LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixunitaire(ligneVente.getPrixunitaire())
                .build();
    }

     public LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return  null;
        }
        LigneVente ligne= new LigneVente();
        ligne.setId(ligneVenteDto.getId());
        ligne.setQuantite(ligneVenteDto.getQuantite());
        ligne.setPrixunitaire(ligneVenteDto.getPrixunitaire());
        return ligne;
     }
}
