package com.inexture.hibernateexa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        
//        Student s1 = new Student(101,"yash","ahmedabad");
//        Student s2 = new Student(105,"abc","ahmedabad");
//        
//        System.out.println(s1);
//        System.out.println(s2);
        
        Session session = factory.openSession();
        
//        Transaction tx = session.beginTransaction();
//        session.save(s1);
//        tx.commit();
//        
//        Transaction tx2 = session.beginTransaction();
//        session.save(s2);
//        tx2.commit();
        
//        session.beginTransaction();
//        session.save(s1);
//        session.save(s2);
//        session.getTransaction().commit();
        
        Student s1 = (Student)session.get(Student.class, 7);
        System.out.println(s1);
        
        Student s2 = (Student)session.load(Student.class, 8);
        System.out.println(s2);
        
        
        session.close();
        
        factory.close();
    }
}
