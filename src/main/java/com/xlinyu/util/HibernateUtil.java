package com.xlinyu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	private HibernateUtil(){
		
	}

	/**
	 * 获取新的session
	 * @return
	 */
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	/**
	 * 获取跟线程相关的session
	 * @return
	 */
	public static Session getCureentSesion(){
		
		Session session = threadLocal.get();
		if(session == null){
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
}
