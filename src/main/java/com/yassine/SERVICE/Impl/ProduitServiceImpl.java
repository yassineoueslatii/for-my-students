package com.yassine.SERVICE.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yassine.DAO.IProduitDao;
import com.yassine.SERVICE.IProduitService;
import com.yassine.entities.Produit;
@Transactional
public class ProduitServiceImpl implements IProduitService {
	private IProduitDao dao;
	

	public void setDao(IProduitDao dao) {
		this.dao = dao;
	}

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Produit update(Produit entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Produit> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Produit> selectAll(String sortfiled, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortfiled, sort);
	}

	@Override
	public Produit getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public Produit findOne(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(parName, paramValue);
	}

	@Override
	public Produit findOne(String[] paraNames, String[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paraNames, paramValues);
	}

	@Override
	public int findCountBy(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(parName, paramValue);
	}

	
}
