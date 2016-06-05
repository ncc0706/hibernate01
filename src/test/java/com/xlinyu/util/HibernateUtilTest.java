package com.xlinyu.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void test() {
		Session s1 = HibernateUtil.getCureentSesion();
		Session s2 = HibernateUtil.getCureentSesion();
		
		System.out.println(s1.hashCode() + " -- " + s2.hashCode());
		
	}

}
