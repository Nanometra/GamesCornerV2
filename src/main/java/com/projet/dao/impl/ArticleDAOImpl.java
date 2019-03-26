package com.projet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.projet.dao.IArticleDAO;
import com.projet.entites.Article;

public class ArticleDAOImpl implements IArticleDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private static EntityManager getEntityManager(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	@Override
	public Article find(Integer id) {
		em = getEntityManager(emf);		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public List<Article> findAll() {
		em = getEntityManager(emf);
		return null;
	}

	@Override
	public void add(Article article) {
		em = getEntityManager(emf);
		em.persist(article);
		em.close();
	}

	@Override
	public void delete(Integer id) {
		em = getEntityManager(emf);
		Article article = em.find(Article.class, id);
		em.remove(article);
		em.close();
	}

	@Override
	public Article update(Article entity) {
		em = getEntityManager(emf);
		
		return null;
	}

}
