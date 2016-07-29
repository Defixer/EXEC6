package com.hibernate.exercise6.dao;

import com.hibernate.exercise6.model.Role;
import com.hibernate.exercise6.model.Employee;
import com.hibernate.exercise6.utilities.HibernateUtil;

import java.util.Scanner;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleDAO{		
	private Scanner scan = new Scanner(System.in);
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private List roleList;		
	private Role thisRole;
		
	public Role getRoleFromDB(int roleID){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			thisRole = (Role)session.get(Role.class, roleID);
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return thisRole;
	}
	
	public void addNewRoleToDB(Role role){		
		SessionFactory factory = hibernateUtil.getSessionFactory();
		boolean loopRoleMenu = true;
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();			
			session.save(role);
			transaction.commit();
			System.out.println("\tRole successfully added");
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public void addRoleToEmployee(Employee employee){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(employee);
			transaction.commit();
			System.out.println("\t\tRole successfully added");
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}				
	}
	
	public void updateRoles(Role thisRole){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(thisRole);
			transaction.commit();
			System.out.println("\t\tRole successfully updated");	
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}				
	}
	
	public void deleteRole(Role thisRole){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.delete(thisRole);
			transaction.commit();			
			System.out.println("\tRole successfully deleted");
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public void deleteRoleFromEmployee(Employee employee){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();			
			session.update(employee);
			transaction.commit();
			System.out.println("\tRole success deleted");
				
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public List getRoleList(){
		SessionFactory factory = hibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();	
			roleList = session.createQuery("FROM Role").list();
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return roleList;		
	}
}
