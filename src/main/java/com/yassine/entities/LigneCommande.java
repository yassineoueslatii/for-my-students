package com.yassine.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue
	private long idLigneCommande;
	private BigDecimal quantite;
	private BigDecimal tva;
	private BigDecimal prixUnitaire;
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit ;
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public long getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public BigDecimal getQuantite() {
		return quantite;
	}
	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}
	public BigDecimal getTva() {
		return tva;
	}
	public void setTva(BigDecimal tva) {
		this.tva = tva;
	}
	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
