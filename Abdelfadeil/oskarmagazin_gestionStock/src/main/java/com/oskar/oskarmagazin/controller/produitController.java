package com.oskar.oskarmagazin.controller;

import com.oskar.oskarmagazin.dao.ProduitRepo;
import com.oskar.oskarmagazin.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/produits")
@CrossOrigin("*")
public class produitController {

    @Autowired
    private ProduitRepo produitRepo;


    @PostMapping(value="/ajout-produit")
    public Produit save(@RequestBody Produit p) {

        return produitRepo.save(p);
    }

    @PutMapping("/modif-produit-img")
    public Produit modifierProduitImage(@RequestParam MultipartFile file, @RequestBody Produit p) {
        //return produitRepo.UpdateArticle(file, p);
        return null;
    }

    @PutMapping("/modif-produit")
    public Produit modifierProduit(@RequestBody Produit p) {
        return produitRepo.save(p);
    }

    @GetMapping("/get-produit")
    public Produit getProduit(@RequestParam(name="id") Long id) {
        return produitRepo.getOne(id);
    }

    @GetMapping("/get-produits-mc")
    public Page<Produit> getArticles(
            @RequestParam(name = "mc", value = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return produitRepo.findByDescriptionContains(mc,  PageRequest.of(page, size));
    }

    @GetMapping("/get-produits")
    public Page<Produit> getProduits(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return produitRepo.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete-produit")
    public void supprimerProduit(@RequestBody Produit p) {
        produitRepo.delete(p);
    }

    @DeleteMapping("/delete-produit-id")
    public void supprimerProduitId(@RequestParam Long id) {
       // Produit p = produitRepo.findById(id).get();
        produitRepo.deleteById(id);
    }




}
