package org.dhanesh.javabrains.hibernate;

import org.dhanesh.javabrains.dtos.Address;
import org.dhanesh.javabrains.dtos.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	public static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		UserDetails ud = new UserDetails();
		ud.setUserId(1L);
		ud.setUserName("Dhanesh");
		
		Address add = new Address();
		add.setCity("Noida");
		add.setPincode("201301");
		add.setState("UP");
		add.setStreet("Sec-72");
		
		Address officeAdd = new Address();
		officeAdd.setCity("Noida");
		officeAdd.setPincode("201301");
		officeAdd.setState("UP");
		officeAdd.setStreet("Sec-63");
		
		ud.setHomeAddress(add);
		ud.setOfficeAddress(officeAdd);
		
		
		Session s = sf.openSession();
		try{
			s.beginTransaction();
			s.persist(ud);
			s.getTransaction().commit();
		}catch(Error e){
			System.out.println("Error occured while create a user :: " + e);
			s.getTransaction().rollback();
		}finally{
			s.close();
		}
		
		UserDetails user2 = getUserForKey(1L);
		System.out.println("UserName :: " + user2.getUserName() + " adress :: " + user2.getHomeAddress().getStreet());
		
		user2 = null;
		s = sf.openSession();
		user2 = s.get(UserDetails.class, 1L);
		s.close();
		System.out.println("the user's rented books are :: " + user2.getRentedBooks().size());
	}
	
	public static UserDetails getUserForKey(long primaryKey){
		UserDetails user = null;
		Session sess = sf.openSession();
		sess.beginTransaction();
		user = sess.get(UserDetails.class, primaryKey);
		sess.close();
		return user;
	}
}
