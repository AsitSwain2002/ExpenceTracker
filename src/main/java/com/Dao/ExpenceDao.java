package com.Dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dto.Expences;
import com.Dto.User;
import com.mysql.cj.Query;

public class ExpenceDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	public void saveExpence(Expences expence) {
		et.begin();
		em.merge(expence);
		et.commit();

	}
    public List<Expences> getExpensesByUserId(int userId) {
            TypedQuery<Expences> query = em.createQuery("FROM Expences WHERE user.id = :userId", Expences.class);
            query.setParameter("userId", userId);
            return query.getResultList();
    }
}
