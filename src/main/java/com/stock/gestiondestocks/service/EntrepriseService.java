package com.stock.gestiondestocks.service;

import com.stock.gestiondestocks.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCodeEntreprise(String codeEntreprise);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
