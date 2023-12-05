package com.example.ecomjsf.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "panier_produit",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<produit> produits;

    @OneToMany
    private List<commande> commandes;

    @ManyToOne
    private user user;
}
