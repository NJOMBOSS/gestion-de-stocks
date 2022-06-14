package com.stock.gestiondestocks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.Adresse;
import com.stock.gestiondestocks.entity.CommandeFournisseur;
import com.stock.gestiondestocks.entity.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    @JsonIgnore
    private List<CommandeFournisseur> commandeFournisseurs;

      public static FournisseurDto fromEntity(Fournisseur fournisseur){
           if(fournisseur == null){
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(fournisseur.getAdresse())
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .build();
    }

     public static Fournisseur toEntity(FournisseurDto fournisseurDto){
          if(fournisseurDto == null){
              return  null;
          }
          Fournisseur fournisseur = new Fournisseur();
          fournisseur.setId(fournisseurDto.getId());
          fournisseur.setNom(fournisseurDto.getNom());
          fournisseur.setPrenom(fournisseurDto.getPrenom());
          fournisseur.setAdresse(fournisseurDto.getAdresse());
          fournisseur.setPhoto(fournisseurDto.getPhoto());
          fournisseur.setMail(fournisseurDto.getMail());
          fournisseur.setNumTel(fournisseurDto.getNumTel());
          return fournisseur;
     }
}
