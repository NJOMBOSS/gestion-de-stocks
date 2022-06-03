package com.approvisionement.approvisionnement.service;

import com.approvisionement.approvisionnement.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByCodeFournisseur(String codeFournisseur);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
