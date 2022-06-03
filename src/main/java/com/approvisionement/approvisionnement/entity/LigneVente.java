package com.approvisionement.approvisionnement.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "idvente")
    private Vente vente;


    @Column(name="quantite")
    private BigDecimal quantite;

    @Column(name="prixunitaire")
    private BigDecimal prixunitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
