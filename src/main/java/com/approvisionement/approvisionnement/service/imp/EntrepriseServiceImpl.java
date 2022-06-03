package com.approvisionement.approvisionnement.service.imp;

import com.approvisionement.approvisionnement.dto.ArticleDto;
import com.approvisionement.approvisionnement.dto.EntrepriseDto;
import com.approvisionement.approvisionnement.entity.Article;
import com.approvisionement.approvisionnement.entity.Entreprise;
import com.approvisionement.approvisionnement.exeception.EntityNotFoundException;
import com.approvisionement.approvisionnement.exeception.ErrorCodes;
import com.approvisionement.approvisionnement.exeception.InvalidEntityException;
import com.approvisionement.approvisionnement.repository.EntrepriseRepository;
import com.approvisionement.approvisionnement.service.EntrepriseService;;
import com.approvisionement.approvisionnement.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Entreprise is not valid{}",entrepriseDto);
            throw new InvalidEntityException("L'entrepise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(
                EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun entreprise avec l'ID =" + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

        @Override
    public EntrepriseDto findByCodeEntreprise(String codeEntreprise){
            if(!StringUtils.hasLength(codeEntreprise)) {
                log.error("Entreprise CODE is null");
                return null;
            }

            Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByCodeEntreprise(codeEntreprise);

            return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->
                    new EntityNotFoundException(
                            "Aucun article avec le CODE = " + codeEntreprise + "n'a ete trouve dans la BDD",
                            ErrorCodes.ENTREPRISE_NOT_FOUND)
            );
        }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto ::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {

        if(id==null){
            log.error("Entreprise ID is null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }
}
