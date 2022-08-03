package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

    Optional<Fournisseur> findFournisseurByCode(String codeEntreprise);
}
