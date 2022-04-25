package com.inexture.hibernateexa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");  
        
//        Student s1 = (Student)context.getBean("student");
//        s1.setName("dummy");
//        s1.setCity("ahmedabad");
//        
//        Address a1 = (Address)context.getBean("address");
//        a1.setHome("171");
//        a1.setCountry("india");
//        s1.setAddress(a1);
//        
//        Student s2 = (Student)context.getBean("student");
//        s2.setName("pqr");
//        s2.setCity("ahmedabad");
//        
//        Address a2 = (Address)context.getBean("address");
//        a2.setHome("108");
//        a2.setCountry("india");
//        s2.setAddress(a2);
//        
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
        
        session.beginTransaction();
        
        Student s5 = (Student)session.get(Student.class, 19);
//        session.save(s1);
//        session.save(s2);
//        session.save(a1);
//        session.save(a2);
        session.delete(s5);
        session.getTransaction().commit();
        
//        Student s1 = (Student)session.get(Student.class, 1);
//        System.out.println(s1);
//        
//        Student s2 = (Student)session.load(Student.class, 2);
//        System.out.println(s2);
        
        
        
        
        session.close();
        
        factory.close();
    }
}
