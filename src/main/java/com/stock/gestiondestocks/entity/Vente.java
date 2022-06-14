package com.stock.gestiondestocks.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vente")
public class Vente extends AbstractEntity{

    @Column(name="code")
    private String code;

    @Column(name="datevente")
    private Date datevente;

    @Column(name="commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVenteList;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
