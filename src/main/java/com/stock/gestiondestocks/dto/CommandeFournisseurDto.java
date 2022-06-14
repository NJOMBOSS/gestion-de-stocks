package com.stock.gestiondestocks.dto;

import com.stock.gestiondestocks.entity.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private  String code;

    private Instant dateCommande;


    private FournisseurDto fournisseurDto;


    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDto;

    public static CommandeFournisseurDto fromEntity (CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null){
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseurDto(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return  null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseur.getId());
        commandeFournisseur.setCode(commandeFournisseur.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseur.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseurDto()));
        return commandeFournisseur;
    }
}
