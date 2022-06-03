package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.Article;
import com.approvisionement.approvisionnement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findClientByCodeClient(String codeClient);
}
