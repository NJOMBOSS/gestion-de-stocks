package com.approvisionement.approvisionnement.repository;


import com.approvisionement.approvisionnement.entity.Category;
import com.approvisionement.approvisionnement.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    Optional<Vente> findVenteByCodeVente(String codeVente);
}
