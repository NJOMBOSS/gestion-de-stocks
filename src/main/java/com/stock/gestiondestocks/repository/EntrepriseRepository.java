package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
    Optional<Entreprise> findEntrepriseByCode(String codeEntreprise);
}
