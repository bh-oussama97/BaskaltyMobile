/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/**
 *
 * @author benha
 */
public class Panier {
    
    private int id_panier;
    private int quantite ; 
    private float prix;
    private int id_prodduct;
    private String name;
    private String image;

    public Panier(int id_panier, int quantite, float prix, String name, String image) {
        this.id_panier = id_panier;
        this.quantite = quantite;
        this.prix = prix;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
   
    public Panier(int id_panier, int quantite, float prix, int id_prodduct) {
        this.id_panier = id_panier;
        this.quantite = quantite;
        this.prix = prix;
        this.id_prodduct = id_prodduct;
    }

    public Panier(int quantite, float prix, int id_prodduct) {
        this.quantite = quantite;
        this.prix = prix;
        this.id_prodduct = id_prodduct;
    }

    public Panier(int id_panier, int quantite, float prix) {
        this.id_panier = id_panier;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_prodduct() {
        return id_prodduct;
    }

    public void setId_prodduct(int id_prodduct) {
        this.id_prodduct = id_prodduct;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", quantite=" + quantite + ", prix=" + prix + ", id_prodduct=" + id_prodduct + '}';
    }
    
    
    
}
