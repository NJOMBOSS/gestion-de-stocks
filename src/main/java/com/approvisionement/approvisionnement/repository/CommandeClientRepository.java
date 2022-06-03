package com.approvisionement.approvisionnement.repository;


import com.approvisionement.approvisionnement.entity.Category;
import com.approvisionement.approvisionnement.entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    Optional<CommandeClient> findCommandeClientByCode(String codeCommandeClient);

}
