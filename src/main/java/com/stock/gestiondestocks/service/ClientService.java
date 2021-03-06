package com.stock.gestiondestocks.service;



import com.stock.gestiondestocks.dto.ClientDto;

import java.util.List;

public interface ClientService {

   ClientDto save(ClientDto clientDto );

    ClientDto  findById(Integer id);

    ClientDto findByCodeClient(String codeClient);

    List<ClientDto > findAll();

    void delete(Integer id);
}
