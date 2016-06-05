package com.xlinyu;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xlinyu.entity.Employee;

public class EmployeeTest {

	private static final Logger logger = Logger.getLogger(EmployeeTest.class);
	
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
	public void addEmployee() {
		
		Transaction tx = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setName("张三");
		employee.setEmail("zhangsan@gmail.com");
		employee.setHiredate(new Date());
		session.save(employee);
		
		tx.commit();
		
	}

	@Test
	public void loadEmployee(){
		Employee employee = (Employee)session.load(Employee.class, 2);
		logger.info(employee.getName());
	}
	
	@Test
	public void updateEmployee(){
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee)session.load(Employee.class, 2);
		employee.setName("李四");
		employee.setEmail("lisi@gmail.com");
		tx.commit();
	}
	
	@Test
	public void deleteEmployee(){
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee)session.load(Employee.class, 1);
		session.delete(employee);
		tx.commit();
	}
	
	@After
	public void after(){
		session.close();
		factory.close();
	}
}
