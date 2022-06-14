package com.stock.gestiondestocks.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;


    private ArticleDto articleDto;

    @JsonIgnore
    private CommandeClientDto commandeClientDto;

    private BigDecimal quantite;

    private BigDecimal prixunitaire;

      public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
          if(ligneCommandeClient == null){
              return null;
          }
          return LigneCommandeClientDto.builder()
                  .id(ligneCommandeClient.getId())
                  .quantite(ligneCommandeClient.getQuantite())
                  .prixunitaire(ligneCommandeClient.getPrixunitaire())
                  .build();
      }

           public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
                if (ligneCommandeClientDto == null){
                    return null;
                }

                LigneCommandeClient l = new LigneCommandeClient();
                l.setId(ligneCommandeClientDto.getId());
                l.setQuantite(ligneCommandeClientDto.getQuantite());
                l.setPrixunitaire(ligneCommandeClientDto.getPrixunitaire());
                return  l;
           }


}
