package com.yassine.SERVICE.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yassine.DAO.ICommandeDao;
import com.yassine.SERVICE.ICommandeService;
import com.yassine.entities.Commande;
@Transactional
public class CommandeServiceImpl implements ICommandeService {

	private ICommandeDao dao;
	
	public void setDao(ICommandeDao dao) {
		this.dao = dao;
	}

	@Override
	public Commande save(Commande entity) {
		// TODO Auto-generated method stub
		return dao.save(entity) ;
	}

	@Override
	public Commande update(Commande entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Commande> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Commande> selectAll(String sortfiled, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortfiled, sort);
	}

	@Override
	public Commande getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public Commande findOne(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(parName, paramValue);
	}

	@Override
	public Commande findOne(String[] paraNames, String[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paraNames, paramValues);
	}

	@Override
	public int findCountBy(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(parName, paramValue);
	}

}
