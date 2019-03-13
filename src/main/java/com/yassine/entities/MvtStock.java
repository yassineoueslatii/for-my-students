package com.yassine.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MvtStock {

	@Id
	@GeneratedValue
	private long idMvtStock;
	private BigDecimal quantite;
	private Date date ;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	
}
