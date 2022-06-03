package com.approvisionement.approvisionnement.dto;

import com.approvisionement.approvisionnement.entity.Adresse;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AdresseDto {

    private Integer id;

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse){
        if(adresse == null){
            return  null;
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse1())
                .ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .build();
    }


    public static Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto == null){
            return  null;
        }
        Adresse adresse= new Adresse();
        adresse.setAdresse1(adresseDto.adresse1);
        adresse.setAdresse2(adresseDto.adresse2);
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostale(adresseDto.codePostale);
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }

}
