package todo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import todo.beans.Course;
import todo.utils.HibernateUtils;

public class HibernateCRUDMain {

	private static void createNewCourse() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
//		Course c= new Course(1,"C++",80,"CDAC",10000);
		
		Course c[]= new Course[5];
		c[0] = new Course(101,"C++",80,"CDAC",10000);
		c[1] = new Course(102,"Python",85,"Udemy",5000);
		c[2] = new Course(103,"Java",100,"Coursera",15000);
		c[3] = new Course(104,"C#",38,"Sunbeam",5000);
		c[4] = new Course(105,"SQL",30,"UpGrad",5000);
				
		Transaction hibernateTransaction = session.beginTransaction();
		for(Course course: c) {
			session.save(course);
		}
		
//		session.save(c);
		
		hibernateTransaction.commit();
		session.close();
		factory.close();
		System.out.println("Course created successfully.");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNewCourse();
	}

}
