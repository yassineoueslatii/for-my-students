package com.yassine.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Commande {

	@Id
	@GeneratedValue
	private long idCommande;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateCommande;
	private BigDecimal totaleCommande;
	
	@JsonIgnore
	@OneToMany(mappedBy="commande")	
	private List<LigneCommande> lignesCommande;
	
	@Transient
	private List<LigneCommande> lignesCommande1;
	
	public List<LigneCommande> getLignesCommande1() {
		return lignesCommande1;
	}

	public void setLignesCommande1(List<LigneCommande> lignesCommande1) {
		this.lignesCommande1 = lignesCommande1;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getIdCommande() {
		return idCommande;
	}
	
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public BigDecimal getTotaleCommande() {
		return totaleCommande;
	}
	public void setTotaleCommande(BigDecimal totaleCommande) {
		this.totaleCommande = totaleCommande;
	}
	
}
