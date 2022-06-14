package com.stock.gestiondestocks.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    @Column(name="rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name="idutilisateur")
    private Utilisateur utilisateur;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
