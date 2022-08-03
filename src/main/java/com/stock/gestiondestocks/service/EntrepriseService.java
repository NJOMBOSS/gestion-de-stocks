package com.stock.gestiondestocks.service;

import com.stock.gestiondestocks.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCode(String codeEntreprise);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
