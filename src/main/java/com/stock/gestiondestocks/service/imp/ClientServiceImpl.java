package com.stock.gestiondestocks.service.imp;

import com.stock.gestiondestocks.dto.ClientDto;
import com.stock.gestiondestocks.entity.Client;
import com.stock.gestiondestocks.exeception.EntityNotFoundException;
import com.stock.gestiondestocks.exeception.ErrorCodes;
import com.stock.gestiondestocks.exeception.InvalidEntityException;
import com.stock.gestiondestocks.repository.ClientRepository;
import com.stock.gestiondestocks.service.ClientService;
import com.stock.gestiondestocks.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("Client is not valid{}",clientDto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return clientDto.fromEntity(clientRepository.save(
                clientDto.toEntity(clientDto)));
    }


    @Override
    public ClientDto findById(Integer id) {
        if(id==null){
            log.error("Article ID is null");
            return  null;
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun client avec l'ID =" + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

   /* @Override
    public ClientDto findByCode(String codeClient) {
        if(!StringUtils.hasLength(codeClient)) {
            log.error("Client CODE is null");
            return null;
        }

        Optional<Client> client = clientRepository.findClientByCode(codeClient);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun client avec le CODE = " + codeClient + "n'a ete trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }*/

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto ::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if(id==null){
            log.error("Client ID is null");
            return ;
        }
        clientRepository.deleteById(id);
    }
}