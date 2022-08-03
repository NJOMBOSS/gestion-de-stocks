package com.stock.gestiondestocks.service;


import com.stock.gestiondestocks.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByCode(String codeUtilisateur);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
