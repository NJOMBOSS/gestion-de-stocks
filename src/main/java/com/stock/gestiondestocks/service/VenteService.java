package com.stock.gestiondestocks.service;

import com.stock.gestiondestocks.dto.VenteDto;

import java.util.List;

public interface VenteService {

   VenteDto save(VenteDto venteDto);

    VenteDto  findById(Integer id);

    VenteDto  findByCodeVente(String codeVente);

    List<VenteDto > findAll();

    void delete(Integer id);
}
