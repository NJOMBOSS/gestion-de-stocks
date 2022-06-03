package com.approvisionement.approvisionnement.repository;

import com.approvisionement.approvisionnement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCodeCategory(String codeCategory);
}
