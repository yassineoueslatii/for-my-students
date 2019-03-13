package com.yassine.SERVICE;

import java.util.List;

import com.yassine.entities.LigneCommande;
import com.yassine.entities.Produit;

public interface ILigneCommandeService {
	public LigneCommande save(LigneCommande entity);
	public LigneCommande update(LigneCommande entity);
	public List<LigneCommande> selectAll();
	public List<LigneCommande> selectAll(String sortfiled, String sort);
	public LigneCommande getById(long id);
	public void remove(long id);
	public LigneCommande findOne(String parName,String paramValue );
	public LigneCommande findOne(String[] paraNames,String[] paramValues );
	public int findCountBy(String parName,String paramValue );
	public List<LigneCommande> getByIdCommande(long idcommande);
	public	Produit getbyIdLigneCommande(long idLigneCommande); 
}
