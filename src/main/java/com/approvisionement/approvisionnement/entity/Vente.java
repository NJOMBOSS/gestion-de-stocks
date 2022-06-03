package com.approvisionement.approvisionnement.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
