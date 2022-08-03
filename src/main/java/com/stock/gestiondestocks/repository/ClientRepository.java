package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

   // Optional<Client> findClientByCode(String codeClient);
}
