package com.user.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.user.beans.User;

public class UserDao {
	public void save(User user){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> query(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "from User";
		List<User> list = session.createQuery(hql).list();
		return list;
	}
	
	
}
