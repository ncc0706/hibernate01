package com.xlinyu;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xlinyu.entity.Employee;

/**
 * get load的区别
 * @author GHeels
 *
 */
public class LoadAndGetTest {

	
private static final Logger logger = Logger.getLogger(LoadAndGetTest.class);
	
	private static SessionFactory factory;
	
	private Session session;
	
	static{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
	}
	
	
	@Before
	public void before(){
		session = factory.openSession();
	}
	
	@Test
	public void getOrLoad(){
		try {
			Employee employee = (Employee)session.load(Employee.class, 1);
			logger.info(employee.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 只会发出一次请求
	 */
	@Test
	public void load01(){
		try {
			Employee employee1 = (Employee)session.load(Employee.class, 1);
			logger.info(employee1.getName());
			Employee employee2 = (Employee)session.load(Employee.class, 1);
			logger.info(employee2.getEmail());
			Employee employee3 = (Employee)session.get(Employee.class, 1);
			logger.info(employee3.getHiredate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@After
	public void after(){
		session.close();
		factory.close();
	}
	
}
