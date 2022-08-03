package com.stock.gestiondestocks.service.imp;


import com.stock.gestiondestocks.dto.FournisseurDto;
import com.stock.gestiondestocks.entity.Fournisseur;
import com.stock.gestiondestocks.exeception.EntityNotFoundException;
import com.stock.gestiondestocks.exeception.ErrorCodes;
import com.stock.gestiondestocks.exeception.InvalidEntityException;
import com.stock.gestiondestocks.repository.FournisseurRepository;
import com.stock.gestiondestocks.service.FournisseurService;
import com.stock.gestiondestocks.validator.FounisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

;

@Service
@Slf4j
public class FounisseurImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FounisseurImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FounisseurValidator.validate(fournisseurDto);
        if(!errors.isEmpty()){
            log.error("Founisseur is not valid{}",fournisseurDto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOUNISSEUR_NOT_VALID, errors);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(
                FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id==null){
            log.error("A FournisseurID is null");
            return  null;
        }
        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun fournisseur avec l'ID =" + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.FOUNISSEUR_NOT_FOUND)
        );
    }

    /*@Override
    public FournisseurDto findByCode(String codeFournisseur) {
        if(!StringUtils.hasLength(codeFournisseur)) {
            log.error("Article CODE is null");
            return null;
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findFournisseurByCode(codeFournisseur);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun founisseur avec le CODE = " + codeFournisseur + "n'a ete trouve dans la BDD",
                        ErrorCodes.FOUNISSEUR_NOT_FOUND)
        );
    }
*/
    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if(id==null){
            log.error("Fournisseur ID is null");
            return ;
        }
       fournisseurRepository.deleteById(id);
    }
}