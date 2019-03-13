package com.yassine.SERVICE;

import java.util.List;

import com.yassine.entities.Article;
import com.yassine.entities.Commande;

public interface IArticleService {
	
		public Article save(Article entity);
		public Article update(Article entity);
		public List<Article> selectAll();
		public List<Article> selectAll(String sortfiled, String sort);
		public Article getById(long id);
		public void remove(long id);
		public Article findOne(String parName,String paramValue );
		public Article findOne(String[] paraNames,String[] paramValues );
		public int findCountBy(String parName,String paramValue );
		
	
	

}
