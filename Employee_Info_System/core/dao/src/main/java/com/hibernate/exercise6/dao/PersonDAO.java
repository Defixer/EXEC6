package com.hibernate.exercise6.dao;

import com.hibernate.exercise6.model.Employee;
import com.hibernate.exercise6.model.Name;
import com.hibernate.exercise6.model.Address;
import com.hibernate.exercise6.model.OtherInfo;
import com.hibernate.exercise6.model.Contact;
import com.hibernate.exercise6.utilities.HibernateUtil;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDAO{
	private Scanner scan = new Scanner(System.in);
	private final String DATE_FLAG = "y";
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private Employee employee;
	private Criteria criteria;
	private Query query;
	private List employeeList;
	private Contact thisContact;
	
	public Employee getEmployeeRecord(Integer employeeID){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, employeeID);
			
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employee;		
	}
	
	public Contact getEmployeeContact(int contactID){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			Contact thisContact = (Contact)session.get(Contact.class, contactID);
			return thisContact;
			
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return thisContact;		
	}
	
	public void updateEmployeeRecordToDB(Employee employee){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List getEmployeeListByCriteria(){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			criteria = session.createCriteria(Employee.class);
			criteria.addOrder(Order.asc("Name.lastName"));
			employeeList = criteria.list();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public List getEmployeeListByHqlQuery(String hql){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			employeeList = query.list();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public List getEmployeeListByQuery(){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			employeeList = session.createQuery("FROM Employee").list();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public void addEmployeeToDB(Employee employee){	
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			System.out.println("\t\tRecord successfully created");
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deleteEmployeeRecord(Integer employeeID){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();	
			Employee employee = (Employee)session.get(Employee.class, employeeID);		
			session.delete(employee);		
			transaction.commit();
			System.out.println("\t\tRecord successfully deleted");			
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void updateRecord(Employee employee, int recordInfoChoice) throws ParseException{
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();						
			
			if(recordInfoChoice >= 1 && recordInfoChoice <= 5){			
				session.update(employee);	
				transaction.commit();
				System.out.println("\t\tRecord successfully updated");
			}
			else if(recordInfoChoice >= 6 && recordInfoChoice <= 9){				
				session.update(employee);	
				transaction.commit();
				System.out.println("\t\tRecord successfully updated");
			}
			else if(recordInfoChoice >= 10 && recordInfoChoice <= 13){			
				session.update(employee);	
				transaction.commit();
				System.out.println("\t\tRecord successfully updated");
			}
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}	
	}
	
	public static Date parseToDate(String day) throws ParseException{
		final String DATE_PATTERN = "yyyy/MM/dd";
		SimpleDateFormat dayFormatter = new SimpleDateFormat(DATE_PATTERN);
		Date date =  dayFormatter.parse(day);
		return date;
	}
	
	/*CONTACTS*/
	public void addContacts(Employee employee){		
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(employee);
			transaction.commit();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deleteContact(Employee employee){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(employee);
			transaction.commit();
			System.out.println("\tContact successfully deleted");			
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}	
	}
	
	public void updateContact(Employee employee){		
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(employee);
			transaction.commit();
			System.out.println("\tContact successfully updated");		
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public String inputNewValue(){
		String newValue = "";
		
		System.out.print("\tEnter new value: ");
		newValue = scan.nextLine();
		
		return newValue;
	}
}
