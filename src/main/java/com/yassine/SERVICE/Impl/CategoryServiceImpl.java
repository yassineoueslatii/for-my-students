package com.yassine.SERVICE.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yassine.DAO.ICategoryDao;
import com.yassine.SERVICE.ICategoryService;
import com.yassine.entities.Category;

@Transactional
public class CategoryServiceImpl implements ICategoryService {
 private ICategoryDao dao;
 
	public ICategoryDao getDao() {
	return dao;
}

public void setDao(ICategoryDao dao) {
	this.dao = dao;
}

	@Override
	public Category save(Category entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Category update(Category entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Category> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Category> selectAll(String sortfiled, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortfiled, sort);
	}

	@Override
	public Category getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public Category findOne(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(parName, paramValue);
	}

	@Override
	public Category findOne(String[] paraNames, String[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paraNames, paramValues);
	}

	@Override
	public int findCountBy(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(parName, paramValue);
	}

}
