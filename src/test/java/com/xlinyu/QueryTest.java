package com.xlinyu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.xlinyu.entity.Employee;
import com.xlinyu.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class QueryTest {

	@Test
	public void query01(){
		
		Session session = HibernateUtil.getCureentSesion();
		
		Query query = session.createQuery(" from Employee where id = 1");
		
		List<Employee> emps = query.list();
		
		for(Employee emp:emps){
			System.out.println(emp.getName());
		}
		
	}
	
	
}
