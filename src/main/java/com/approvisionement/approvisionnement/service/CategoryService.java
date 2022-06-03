package com.approvisionement.approvisionnement.service;


import com.approvisionement.approvisionnement.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save( CategoryDto   categoryDto );

    CategoryDto findById(Integer id);

    CategoryDto  findByCode(String codeCategory);

    List< CategoryDto > findAll();

    void delete(Integer id);

}
