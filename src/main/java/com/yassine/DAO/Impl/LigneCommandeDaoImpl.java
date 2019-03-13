package com.yassine.DAO.Impl;

import java.util.List;

import javax.persistence.Query;

import com.yassine.DAO.ILigneCommandeDao;
import com.yassine.entities.LigneCommande;
import com.yassine.entities.Produit;

public class LigneCommandeDaoImpl extends GenericDaoImpl<LigneCommande> implements ILigneCommandeDao {

	@Override
	public List<LigneCommande> getByIdCommande(long idcommande) {
		String hql="select lc from " + LigneCommande.class.getSimpleName()+ " lc where lc.commande.idCommande = :x";
		Query query=em.createQuery(hql);
		query.setParameter("x", idcommande);
		
		return query.getResultList();
	}

	@Override
	public Produit getbyIdLigneCommande(long idLigneCommande) {
		String hql="select lc from " + LigneCommande.class.getSimpleName()+ " lc where lc.produit.idProduit = :x";
		Query query=em.createQuery(hql);
		query.setParameter("x", idLigneCommande);
		return (Produit) query.getSingleResult();
	}

}
