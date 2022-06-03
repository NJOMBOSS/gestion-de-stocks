package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {
}
