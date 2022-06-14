package com.stock.gestiondestocks.repository;

import com.stock.gestiondestocks.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findUtilisateurByCodeUtilisateur(String codeUtilisateur);
}
