package com.yassine.SERVICE;

import java.util.List;

import com.yassine.entities.MvtStock;

public interface IMvtStockService  {
	public MvtStock save(MvtStock entity);
	public MvtStock update(MvtStock entity);
	public List<MvtStock> selectAll();
	public List<MvtStock> selectAll(String sortfiled, String sort);
	public MvtStock getById(long id);
	public void remove(long id);
	public MvtStock findOne(String parName,String paramValue );
	public MvtStock findOne(String[] paraNames,String[] paramValues );
	public int findCountBy(String parName,String paramValue );	
}
