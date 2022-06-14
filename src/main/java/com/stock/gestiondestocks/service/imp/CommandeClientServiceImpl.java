package com.stock.gestiondestocks.service.imp;


import com.stock.gestiondestocks.dto.CommandeClientDto;
import com.stock.gestiondestocks.dto.LigneCommandeClientDto;
import com.stock.gestiondestocks.entity.Article;
import com.stock.gestiondestocks.entity.Client;
import com.stock.gestiondestocks.entity.CommandeClient;
import com.stock.gestiondestocks.entity.LigneCommandeClient;
import com.stock.gestiondestocks.exeception.EntityNotFoundException;
import com.stock.gestiondestocks.exeception.ErrorCodes;
import com.stock.gestiondestocks.exeception.InvalidEntityException;
import com.stock.gestiondestocks.repository.ArticleRepository;
import com.stock.gestiondestocks.repository.ClientRepository;
import com.stock.gestiondestocks.repository.CommandeClientRepository;
import com.stock.gestiondestocks.repository.LigneCommandeClientRepository;
import com.stock.gestiondestocks.service.CommandeClientService;
import com.stock.gestiondestocks.validator.CommandeClientValidator;
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

        Optional<Client> client = clientRepository.findById(commandeClientDto.getClientDto().getId());
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
