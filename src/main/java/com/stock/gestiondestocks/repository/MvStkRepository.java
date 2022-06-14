package com.stock.gestiondestocks.repository;


import com.stock.gestiondestocks.entity.MvStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvStkRepository extends JpaRepository<MvStk, Integer> {
}
