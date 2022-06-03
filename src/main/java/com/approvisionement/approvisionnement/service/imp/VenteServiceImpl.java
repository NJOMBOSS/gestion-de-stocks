package com.approvisionement.approvisionnement.service.imp;

import com.approvisionement.approvisionnement.dto.VenteDto;
import com.approvisionement.approvisionnement.service.VenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {


    @Override
    public VenteDto save(VenteDto venteDto) {
        return null;
    }

    @Override
    public VenteDto findById(Integer id) {
        return null;
    }

    @Override
    public VenteDto findByCodeVente(String codeVente) {
        return null;
    }

    @Override
    public List<VenteDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
