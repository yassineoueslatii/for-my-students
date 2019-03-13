package com.yassine.SERVICE.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yassine.DAO.IMvtStockDao;
import com.yassine.SERVICE.IMvtStockService;
import com.yassine.entities.MvtStock;
@Transactional
public class MvtStockServiceImpl implements IMvtStockService {
	private IMvtStockDao dao;

	public void setDao(IMvtStockDao dao) {
		this.dao = dao;
	}

	@Override
	public MvtStock save(MvtStock entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public MvtStock update(MvtStock entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<MvtStock> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<MvtStock> selectAll(String sortfiled, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortfiled, sort);
	}

	@Override
	public MvtStock getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public MvtStock findOne(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(parName, paramValue);
	}

	@Override
	public MvtStock findOne(String[] paraNames, String[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paraNames, paramValues);
	}

	@Override
	public int findCountBy(String parName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(parName, paramValue);
	}

	

}
