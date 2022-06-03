package com.approvisionement.approvisionnement.service;

import com.approvisionement.approvisionnement.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto  commandeClientDto);

    CommandeClientDto  findById(Integer id);

    CommandeClientDto  findByCodeCommandeClient(String codeCommandeClient);

    List<CommandeClientDto > findAll();

    void delete(Integer id);
}
