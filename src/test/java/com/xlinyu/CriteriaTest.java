package com.xlinyu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.junit.Test;

import com.xlinyu.entity.Employee;
import com.xlinyu.util.HibernateUtil;

public class CriteriaTest {

	@Test
	public void test() {
	
		Session session = HibernateUtil.getCureentSesion();
		
		@SuppressWarnings("unchecked")
		List<Employee> emps = session.createCriteria(Employee.class)
				.setMaxResults(3)
				.addOrder(Order.desc("id"))
				.list();
		for(Employee emp:emps){
			System.out.println(emp.getId());
		}
	}

}
