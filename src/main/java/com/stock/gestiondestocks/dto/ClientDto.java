package com.stock.gestiondestocks.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestiondestocks.entity.Adresse;
import com.stock.gestiondestocks.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClientDto;

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }
         return ClientDto.builder()
                 .id(client.getId())
                 .nom(client.getNom())
                 .prenom(client.getPrenom())
                 .adresse(client.getAdresse())
                 .photo(client.getPhoto())
                 .mail(client.getMail())
                 .numTel(client.getNumTel())
                 .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }

        Client client= new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(clientDto.getAdresse());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(client.getNumTel());
        return client;
    }

}
