package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    Optional<Vente> findVenteByCode(String codeVente);
}
