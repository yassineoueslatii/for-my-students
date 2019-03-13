package com.yassine.SERVICE;

import java.util.List;

import com.yassine.entities.Article;
import com.yassine.entities.Produit;

public interface IProduitService {
	
	public Produit save(Produit entity);
	public Produit update(Produit entity);
	public List<Produit> selectAll();
	public List<Produit> selectAll(String sortfiled, String sort);
	public Produit getById(long id);
	public void remove(long id);
	public Produit findOne(String parName,String paramValue );
	public Produit findOne(String[] paraNames,String[] paramValues );
	public int findCountBy(String parName,String paramValue );	
	
}
