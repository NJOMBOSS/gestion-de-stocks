package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
    Optional<Entreprise> findEntrepriseByCodeEntreprise(String codeEntreprise);
}
