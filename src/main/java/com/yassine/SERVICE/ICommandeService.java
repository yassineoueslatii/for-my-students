package com.yassine.SERVICE;

import java.util.List;

import com.yassine.entities.Commande;



public interface ICommandeService  {
	public Commande save(Commande entity);
	public Commande update(Commande entity);
	public List<Commande> selectAll();
	public List<Commande> selectAll(String sortfiled, String sort);
	public Commande getById(long id);
	public void remove(long id);
	public Commande findOne(String parName,String paramValue );
	public Commande findOne(String[] paraNames,String[] paramValues );
	public int findCountBy(String parName,String paramValue );
}
