package com.approvisionement.approvisionnement.service;

import com.approvisionement.approvisionnement.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByCodeUtilisateur(String codeUtilisateur);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
