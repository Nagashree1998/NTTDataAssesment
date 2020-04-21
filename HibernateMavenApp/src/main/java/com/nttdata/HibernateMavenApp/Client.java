package com.nttdata.HibernateMavenApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Scanner in=new Scanner(System.in);
		User user=new User();
		System.out.println("Enter User ID");
		int userId=in.nextInt();
		System.out.println("Enter UserName");
		String userName=in.next();
		user.setUserId(userId);
		user.setUserName(userName);
		
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

	}

}
