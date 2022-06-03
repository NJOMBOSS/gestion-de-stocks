package com.approvisionement.approvisionnement.service;



import com.approvisionement.approvisionnement.dto.ClientDto;

import java.util.List;

public interface ClientService {

   ClientDto save(ClientDto  clientDto );

    ClientDto  findById(Integer id);

    ClientDto findByCodeClient(String codeClient);

    List<ClientDto > findAll();

    void delete(Integer id);
}
