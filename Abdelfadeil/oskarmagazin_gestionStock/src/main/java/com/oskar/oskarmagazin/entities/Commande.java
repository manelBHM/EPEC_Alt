package com.oskar.oskarmagazin.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Commande implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateCommande;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    private List<Produit> produits;
    private String ETAT;

    public Commande(Client client, List<Produit> produits){
        this.client= client;
        this.produits= produits;
        this.dateCommande = LocalDateTime.now();
        this.ETAT = "NON_PAYEE";
    }

}

