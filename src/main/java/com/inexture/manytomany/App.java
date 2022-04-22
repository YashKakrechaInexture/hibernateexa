package com.inexture.manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inexture.onetomany.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory factory = new Configuration().configure("com/inexture/manytomany/hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        
//        @SuppressWarnings("resource")
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");  
//        
//        Employee emp1 = (Employee)context.getBean("employee");
//        emp1.setEmpname("yash");
//        
//        Employee emp2 = (Employee)context.getBean("employee");
//        emp2.setEmpname("brijesh");
//        
//        Employee emp3 = (Employee)context.getBean("employee");
//        emp3.setEmpname("jaydeep");
//        
//        Project p1 = (Project)context.getBean("project");
//        p1.setPname("java");
//        
//        Project p2 = (Project)context.getBean("project");
//        p2.setPname("python");
//        
//        Project p3 = (Project)context.getBean("project");
//        p3.setPname("c++");
//        
//        @SuppressWarnings("unchecked")
//		List<Project> list1 = (List<Project>)context.getBean("list");
//        list1.add(p1);
//        list1.add(p3);
//        emp1.setProjects(list1);
//        
//        @SuppressWarnings("unchecked")
//		List<Project> list2 = (List<Project>)context.getBean("list");
//        list2.add(p1);
//        list2.add(p2);
//        emp2.setProjects(list2);
//        
//        @SuppressWarnings("unchecked")
//		List<Project> list3 = (List<Project>)context.getBean("list");
//        list3.add(p2);
//        list3.add(p3);
//        emp3.setProjects(list3);
//        
//        @SuppressWarnings("unchecked")
//		List<Employee> list4 = (List<Employee>)context.getBean("list");
//        list4.add(emp1);
//        list4.add(emp2);
//        p1.setEmployees(list4);
//        
//        @SuppressWarnings("unchecked")
//		List<Employee> list5 = (List<Employee>)context.getBean("list");
//        list5.add(emp2);
//        list5.add(emp3);
//        p2.setEmployees(list5);
//        
//        @SuppressWarnings("unchecked")
//		List<Employee> list6 = (List<Employee>)context.getBean("list");
//        list6.add(emp1);
//        list6.add(emp3);
//        p3.setEmployees(list6);
        
        
        
        Session session = factory.openSession();
        
//        @SuppressWarnings("resource")
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");  
//      
//        Employee emp1 = (Employee)context.getBean("employee");
//        emp1.setEid(2);
//        emp1.setEmpname("brijesh");
//        
//        Employee emp2 = (Employee)context.getBean("employee");
//        emp2.setEid(7);
//        
//        session.beginTransaction();
//        session.update(emp1);
//        session.delete(emp2);
//        session.getTransaction().commit();
//        session.close();
        
//        session.beginTransaction();
//        session.save(emp1);
//        session.save(emp2);
//        session.save(emp3);
//        session.save(p1);
//        session.save(p2);
//        session.save(p3);
        
//        Employee s5 = (Employee)session.get(Employee.class, 1);
//        System.out.println(s5);
        
//        System.out.println(s5.getEid());
//        System.out.println(s5.getEmpname());
//        
//        List<Project> projects = s5.getProjects();
//
//        for(Project p : projects) {
//        	System.out.println(p.getPid()+" : "+p.getPname());
//        }
        
//        Project p6 = (Project)session.get(Project.class, 6);
//        System.out.println(p6);
        
//        session.getTransaction().commit();
//        
        
        Query q = session.createQuery("from Employee where eid=2");
        
        List<Employee> list = q.list();
        
        for(Employee e : list) {
        	System.out.println(e);
        }
        
        Query q1 = session.createQuery("select e.empname,p.pname from Employee as e INNER JOIN e.projects as p where eid=1");
        List<Object[]> list1 = q1.list();
        
        for(Object[] e : list1) {
        	System.out.println(e[0]+" : "+e[1]);
        }
        
//        Query q2 = session.createQuery("from Employee where empname='yash'");
//        Employee e2 = (Employee) q2.uniqueResult();
//        System.out.println(e2);
//        
//        Query q3 = session.createQuery("from Employee where empname=:n");
//        q3.setParameter("n", "yash");
//        Employee e3 = (Employee) q3.uniqueResult();
//        System.out.println(e3);
//        
//        NativeQuery nq = session.createSQLQuery("select * from Employee");
//        List<Object[]> list4 = nq.list();
//        for(Object[] e : list4) {
//        	System.out.println(Arrays.deepToString(e));
//        }
//        
//        Criteria c = session.createCriteria(Employee.class);
//        c.add(Restrictions.eq("empname", "yash"));
//        List<Employee> list5 = c.list();
//        for(Employee e : list5) {
//        	System.out.println(e);
//        }
        
        
        session.close();
        
        factory.close();
    }
}
