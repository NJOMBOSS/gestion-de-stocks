package com.stock.gestiondestocks.repository;

import com.stock.gestiondestocks.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCodeCategory(String codeCategory);
}
