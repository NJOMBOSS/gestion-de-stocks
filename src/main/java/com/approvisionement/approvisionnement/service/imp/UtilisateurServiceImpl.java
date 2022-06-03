package com.approvisionement.approvisionnement.service.imp;



import com.approvisionement.approvisionnement.dto.UtilisateurDto;
import com.approvisionement.approvisionnement.entity.Utilisateur;
import com.approvisionement.approvisionnement.exeception.EntityNotFoundException;
import com.approvisionement.approvisionnement.exeception.ErrorCodes;
import com.approvisionement.approvisionnement.exeception.InvalidEntityException;
import com.approvisionement.approvisionnement.repository.UtilisateurRepository;
import com.approvisionement.approvisionnement.service.UtilisateurService;
import com.approvisionement.approvisionnement.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {

        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid{}",utilisateurDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(
                UtilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id==null){
            log.error("Utilisateur ID is null");
            return  null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of( UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun  utilisateur avec l'ID =" + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public UtilisateurDto findByCodeUtilisateur(String codeUtilisateur) {
        if(!StringUtils.hasLength(codeUtilisateur)) {
            log.error("Utilisateur CODE is null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByCodeUtilisateur(codeUtilisateur);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun utilisateur avec le CODE = " + codeUtilisateur + "n'a ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto ::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {

        if(id==null){
            log.error("Utilisateur ID is null");
            return ;
        }
       utilisateurRepository.deleteById(id);
    }
}