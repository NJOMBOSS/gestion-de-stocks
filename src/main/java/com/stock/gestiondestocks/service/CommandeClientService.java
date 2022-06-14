package com.stock.gestiondestocks.service;


import com.stock.gestiondestocks.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto  commandeClientDto);

    CommandeClientDto  findById(Integer id);

    CommandeClientDto  findByCodeCommandeClient(String codeCommandeClient);

    List<CommandeClientDto > findAll();

    void delete(Integer id);
}
