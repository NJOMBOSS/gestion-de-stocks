package com.approvisionement.approvisionnement.service.imp;

import com.approvisionement.approvisionnement.dto.CommandeClientDto;
import com.approvisionement.approvisionnement.dto.LigneCommandeClientDto;
import com.approvisionement.approvisionnement.dto.UtilisateurDto;
import com.approvisionement.approvisionnement.entity.*;
import com.approvisionement.approvisionnement.exeception.EntityNotFoundException;
import com.approvisionement.approvisionnement.exeception.ErrorCodes;
import com.approvisionement.approvisionnement.exeception.InvalidEntityException;
import com.approvisionement.approvisionnement.repository.ArticleRepository;
import com.approvisionement.approvisionnement.repository.ClientRepository;
import com.approvisionement.approvisionnement.repository.CommandeClientRepository;
import com.approvisionement.approvisionnement.repository.LigneCommandeClientRepository;
import com.approvisionement.approvisionnement.service.CommandeClientService;
import com.approvisionement.approvisionnement.validator.ArticleValidator;
import com.approvisionement.approvisionnement.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,
                                     ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository=ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> errors = CommandeClientValidator.validate(commandeClientDto);
        if(!errors.isEmpty()){
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        Optional< Client > client = clientRepository.findById(commandeClientDto.getClientDto().getId());
        if(client.isEmpty()){
            log.warn("Client  with ID {} was not found in the BD",commandeClientDto.getClientDto().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID"+ commandeClientDto.getClientDto().getId() + "n'a ete trouve dans la BDD",ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if(commandeClientDto.getLigneCommandeClientDto() != null){
            commandeClientDto.getLigneCommandeClientDto().forEach(ligCmdClt->{
                if(ligCmdClt.getArticleDto() != null){
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticleDto().getId());
                    if (article.isEmpty()){
                        articleErrors.add("L'article avec l'ID" + ligCmdClt.getArticleDto().getId() + "n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article NULL");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeClient saveCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));

        if(commandeClientDto.getLigneCommandeClientDto() != null){
            commandeClientDto.getLigneCommandeClientDto().forEach(ligCmdClt ->{
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(saveCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(saveCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new  EntityNotFoundException(
                        "Aucune commande client n' a ete trouve avec l'ID" + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
        );
    }

    @Override
    public CommandeClientDto findByCodeCommandeClient(String codeCommandeClient) {
        if(!StringUtils.hasLength(codeCommandeClient)) {
            log.error("Commande client CODE is null");
            return null;
        }

       return commandeClientRepository.findCommandeClientByCode(codeCommandeClient)
               .map(CommandeClientDto::fromEntity)
               .orElseThrow(()-> new EntityNotFoundException(
                       "Aucune commande client n'a ete trouve avec le CODE" + codeCommandeClient, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
               );
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return ;
        }
        commandeClientRepository.deleteById(id);
    }
}
