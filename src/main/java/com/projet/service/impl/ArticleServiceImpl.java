package com.projet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.projet.dao.IArticleDAO;
import com.projet.entites.Article;
import com.projet.service.IArticleService;
import com.projet.utils.DAOUtils;

@Transactional
public class ArticleServiceImpl implements IArticleService {

	private  IArticleDAO articleDao;
	
	public ArticleServiceImpl(IArticleDAO articleDao) {
		super();
		this.articleDao = DAOUtils.getArticleDAO();
	}

	
	@Override
	public Article find(Integer id) {
		return articleDao.find(id);
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public void add(Article article) {
		articleDao.add(article);
	}

	@Override
	public void delete(Integer id) {
		articleDao.delete(id);
	}

	@Override
	public void update(Article article) {
		articleDao.update(article);
	}

}
