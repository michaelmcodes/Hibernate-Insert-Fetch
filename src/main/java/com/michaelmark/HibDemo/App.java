package com.michaelmark.HibDemo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// inserting values into laptop table
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");
        // inserting values into student table
        Student s = new Student();
        s.setName("Mike");
        s.setRollno(1);
        s.setMarks(50);
        s.getLaptop().add(laptop);
        
        laptop.getStudent().add(s);
    	
    	// configuring database
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = config.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        // saving objects in the database
        session.beginTransaction();
        session.save(laptop);
        session.save(s);
        session.getTransaction().commit();
        
        // fetching the data
        Student s1 = (Student)session.get(Student.class, 1); // convert session object to student object
        System.out.println(s1.toString());

    }
}
