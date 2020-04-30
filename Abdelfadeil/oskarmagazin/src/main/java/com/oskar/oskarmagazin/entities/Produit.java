package com.oskar.oskarmagazin.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String prix;
    private String photo;
    @OneToOne
    private DetailCommande detailCommande;
    private boolean disponible;
}

