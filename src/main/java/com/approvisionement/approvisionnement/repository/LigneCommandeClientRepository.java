package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
}
