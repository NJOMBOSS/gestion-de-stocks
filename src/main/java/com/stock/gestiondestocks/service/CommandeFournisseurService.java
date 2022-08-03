package com.stock.gestiondestocks.service;

import com.stock.gestiondestocks.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto  findById(Integer id);

   // CommandeFournisseurDto findByCode(String codeCommandeFournisseur);

    List<CommandeFournisseurDto > findAll();

    void delete(Integer id);
}
