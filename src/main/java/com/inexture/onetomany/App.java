package com.inexture.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
        SessionFactory factory = new Configuration().configure("com/inexture/onetomany/hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");  
        
        Student s1 = (Student)context.getBean("student");
        s1.setName("def");
        s1.setCity("ahmedabad");
        
        Address a1 = (Address)context.getBean("address");
        a1.setHome("107");
        a1.setCountry("india");
        a1.setStudent(s1);
        Address a2 = (Address)context.getBean("address");
        a2.setHome("108");
        a2.setCountry("india");
        a2.setStudent(s1);
        
        @SuppressWarnings("unchecked")
		List<Address> list = (List<Address>)context.getBean("list");
        list.add(a1);
        list.add(a2);
        s1.setAddress(list);
        
        Student s2 = (Student)context.getBean("student");
        s2.setName("pqr");
        s2.setCity("ahmedabad");
        
        Address a3 = (Address)context.getBean("address");
        a3.setHome("109");
        a3.setCountry("india");
        a3.setStudent(s2);
        Address a4 = (Address)context.getBean("address");
        a4.setHome("110");
        a4.setCountry("india");
        a4.setStudent(s2);
        
        @SuppressWarnings("unchecked")
		List<Address> list2 = (List<Address>)context.getBean("list");
        list2.add(a3);
        list2.add(a4);
        s2.setAddress(list2);
        
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
//        session.save(s1);
//        session.save(s2);
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
//        session.save(a4);
        Student s5 = (Student)session.get(Student.class, 1);
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
