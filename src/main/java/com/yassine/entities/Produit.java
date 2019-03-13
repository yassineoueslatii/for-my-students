package com.yassine.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Produit {
@Id
@GeneratedValue
private long idProduit;
private String nomProduit;
private BigDecimal quantite;

@JsonIgnore
@OneToMany(mappedBy="produit")
private List<LigneCommande> lignesCommandes;

@JsonIgnore
@OneToMany(mappedBy="produit")
private List<MvtStock> mvtStocks ;


public List<LigneCommande> getLignesCommandes() {
	return lignesCommandes;
}

public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
	this.lignesCommandes = lignesCommandes;
}
public long getIdProduit() {
	return idProduit;
}
public void setIdProduit(long idProduit) {
	this.idProduit = idProduit;
}
public String getNomProduit() {
	return nomProduit;
}
public void setNomProduit(String nomProduit) {
	this.nomProduit = nomProduit;
}
public BigDecimal getQuantite() {
	return quantite;
}
public void setQuantite(BigDecimal quantite) {
	this.quantite = quantite;
}
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}



}
