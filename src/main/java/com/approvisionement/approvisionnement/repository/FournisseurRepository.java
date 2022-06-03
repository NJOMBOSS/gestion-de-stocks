package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.Entreprise;
import com.approvisionement.approvisionnement.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

    Optional<Fournisseur> findFournisseurByCodeFournisseur(String codeEntreprise);
}
