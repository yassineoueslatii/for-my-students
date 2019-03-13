package com.yassine.SERVICE.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yassine.DAO.ILigneCommandeDao;
import com.yassine.SERVICE.ILigneCommandeService;
import com.yassine.entities.LigneCommande;
import com.yassine.entities.Produit;
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	
	private ILigneCommandeDao dao;
	
	public void setDao(ILigneCommandeDao dao) {
		this.dao = dao;
	}

	@Override
	public LigneCommande save(LigneCommande entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public LigneCommande update(LigneCommande entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneCommande> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneCommande> selectAll(String sortfiled, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortfiled, sort);
	}

	@Override
	public LigneCommande getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public LigneCommande findOne(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(parName, paramValue);
	}

	@Override
	public LigneCommande findOne(String[] paraNames, String[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paraNames, paramValues);
	}

	@Override
	public int findCountBy(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(parName, paramValue);
	}

	@Override
	public List<LigneCommande> getByIdCommande(long idcommande) {
		// TODO Auto-generated method stub
		return dao.getByIdCommande(idcommande);
	}

	@Override
	public Produit getbyIdLigneCommande(long idLigneCommande) {
		// TODO Auto-generated method stub
		return dao.getbyIdLigneCommande(idLigneCommande);
	}

}
