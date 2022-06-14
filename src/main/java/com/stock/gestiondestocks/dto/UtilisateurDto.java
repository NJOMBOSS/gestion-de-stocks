package com.stock.gestiondestocks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.Adresse;
import com.stock.gestiondestocks.entity.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Instant dateDenaissance;

    private String email;

    private String motDePasse;

    private Adresse adresse;

    private String photo;

    @JsonIgnore
    private EntrepriseDto entrepriseDto;

    @JsonIgnore
    private List<RoleDto> roleDto;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur == null){
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .dateDenaissance(utilisateur.getDateDenaissance())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .adresse(utilisateur.getAdresse())
                .photo(utilisateur.getPhoto())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return null;
        }

        Utilisateur u = new Utilisateur();
        u.setId(utilisateurDto.getId());
        u.setNom(utilisateurDto.getNom());
        u.setPrenom(utilisateurDto.getPrenom());
        u.setEmail(utilisateurDto.getEmail());
        u.setMotDePasse(utilisateurDto.getMotDePasse());
        u.setAdresse(utilisateurDto.getAdresse());
        u.setPhoto(utilisateurDto.getPhoto());
        return u;
    }


}
