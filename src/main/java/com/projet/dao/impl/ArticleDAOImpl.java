package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.projet.commons.DAOUtils;
import com.projet.dao.IArticleDAO;
import com.projet.entites.Article;

public class ArticleDAOImpl implements IArticleDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

//	private static EntityManager getEntityManager(EntityManagerFactory emf) {
//		EntityManager em = emf.createEntityManager();
//		return em;
//	}

	public ArticleDAOImpl() {
		super();
	}

	@Override
	public Article find(Integer id) {
		em = DAOUtils.getEntityManager(emf);
		Article article = em.find(Article.class, id);
		em.close();
		return article;
	}

	@Override
	public List<Article> findAll() {
		em = DAOUtils.getEntityManager(emf);

		em.close();
		return null;
	}

	@Override
	public void add(Article article) {
		em = DAOUtils.getEntityManager(emf);
		em.persist(article);
		em.close();
	}

	@Override
	public void delete(Integer id) {
		em = DAOUtils.getEntityManager(emf);
		Article article = em.find(Article.class, id);
		em.remove(article);
		em.close();
	}

	@Override
	public void update(Article entity) {
		em = DAOUtils.getEntityManager(emf);

		Article article = em.find(Article.class, entity.getId());
		em.merge(entity);

	}

}
