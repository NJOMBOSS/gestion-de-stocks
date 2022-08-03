package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

  //  Optional<CommandeFournisseur> findCommandeFournisseurByCode(String codeCommandeFournisseur);
}
