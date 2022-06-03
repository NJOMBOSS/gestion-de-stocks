package com.approvisionement.approvisionnement.service;

import com.approvisionement.approvisionnement.dto.VenteDto;

import java.util.List;

public interface VenteService {

   VenteDto save(VenteDto venteDto);

    VenteDto  findById(Integer id);

    VenteDto  findByCodeVente(String codeVente);

    List<VenteDto > findAll();

    void delete(Integer id);
}
