package com.approvisionement.approvisionnement.service;

import com.approvisionement.approvisionnement.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto  findById(Integer id);

    CommandeFournisseurDto findByCodeCommandeClient(String codeCommandeFournisseur);

    List<CommandeFournisseurDto > findAll();

    void delete(Integer id);
}
