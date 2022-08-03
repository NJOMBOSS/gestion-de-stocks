package com.stock.gestiondestocks.service.imp;

import com.stock.gestiondestocks.dto.CategoryDto;
import com.stock.gestiondestocks.entity.Category;
import com.stock.gestiondestocks.exeception.EntityNotFoundException;
import com.stock.gestiondestocks.exeception.ErrorCodes;
import com.stock.gestiondestocks.exeception.InvalidEntityException;
import com.stock.gestiondestocks.repository.CategoryRepository;
import com.stock.gestiondestocks.service.CategoryService;
import com.stock.gestiondestocks.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);

        if(!errors.isEmpty()){
            log.error("Article is not valid{}",categoryDto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(
                CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id==null){
            log.error("Category ID is null");
            return  null;
        }
        Optional<Category> category =categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucune categorie avec l'ID =" + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCode(String codeCategory) {
        if(!StringUtils.hasLength(codeCategory)) {
            log.error("Category CODE is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(codeCategory)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune categorie avec le CODE = " + codeCategory + "n'a ete dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Categorie ID is null");
            return ;
        }
        categoryRepository.deleteById(id);
    }
}
