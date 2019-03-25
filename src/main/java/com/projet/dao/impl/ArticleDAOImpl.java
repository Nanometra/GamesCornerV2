package com.projet.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projet.dao.IArticleDAO;
import com.projet.entites.Article;

public class ArticleDAOImpl implements IArticleDAO {

//	Map<String, String> properties = new HashMap<String, String>();
//	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamesCornerV2_PU", properties);
	
	@Override
	public Article find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Article entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article update(Article entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
