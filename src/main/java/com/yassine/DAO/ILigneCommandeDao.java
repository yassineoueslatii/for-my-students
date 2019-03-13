package com.yassine.DAO;

import java.util.List;

import com.yassine.entities.LigneCommande;
import com.yassine.entities.Produit;

public interface ILigneCommandeDao extends IGenericDao<LigneCommande> {
	List<LigneCommande> getByIdCommande(long idcommande);	
public	Produit getbyIdLigneCommande(long idLigneCommande); 
	

}
