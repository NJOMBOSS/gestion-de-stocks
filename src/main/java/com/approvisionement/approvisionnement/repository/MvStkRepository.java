package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.MvStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvStkRepository extends JpaRepository<MvStk, Integer> {
}
