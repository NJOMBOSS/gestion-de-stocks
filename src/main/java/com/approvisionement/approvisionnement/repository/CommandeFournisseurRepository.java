package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.Client;
import com.approvisionement.approvisionnement.entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository <CommandeFournisseur, Integer>{

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String codeCommandeFournisseur);
}
