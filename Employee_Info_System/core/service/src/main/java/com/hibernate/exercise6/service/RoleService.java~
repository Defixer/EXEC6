package com.hibernate.exercise6.service;

import com.hibernate.exercise6.dao.PersonDAO;
import com.hibernate.exercise6.dao.RoleDAO;
import com.hibernate.exercise6.model.Employee;
import com.hibernate.exercise6.model.Name;
import com.hibernate.exercise6.model.Address;
import com.hibernate.exercise6.model.OtherInfo;
import com.hibernate.exercise6.model.Contact;
import com.hibernate.exercise6.model.Role;
import com.hibernate.exercise6.utilities.HibernateUtil;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.MessageFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.NoSuchElementException;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleService{
	RoleDAO roleDAO = new RoleDAO();
	PersonDAO personDAO = new PersonDAO();
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private Scanner scan = new Scanner(System.in);
	
	public boolean addNewRoleToDB(String roleName){
		boolean loopRoleMenu = true;
		
		Role role = new Role(roleName);			
		roleDAO.addNewRoleToDB(role);	
		return loopRoleMenu;
	}
	
	public boolean deleteRoleFromDB(int roleID){
		boolean loopRoleMenu = true;
		
		Role thisRole = roleDAO.getRoleFromDB(roleID);				
		roleDAO.deleteRole(thisRole);
		return loopRoleMenu;
	}
	
	public boolean addRoleToEmployee(Integer employeeID, int roleID){
		boolean loopRoleMenu = true;
		
		Role thisRole = roleDAO.getRoleFromDB(roleID);
		Employee employee = personDAO.getEmployeeRecord(employeeID);
		Set roles = employee.getRole();
		roles.add(thisRole);
		employee.setRole(roles);
		roleDAO.addRoleToEmployee(employee);	
		return loopRoleMenu;
	}
	
	public boolean deleteRoleFromEmployee(int employeeID, int roleID){
		boolean loopRoleMenu = true;
		
		Employee employee = personDAO.getEmployeeRecord(employeeID);
		Role thisRole = roleDAO.getRoleFromDB(roleID);
		Set roles = employee.getRole();
		roles.remove(thisRole);			
		roleDAO.deleteRoleFromEmployee(employee);			
		return loopRoleMenu;
	}
	
	public boolean switchUpdateRoles(int roleID, String roleName){
		boolean loopRecordMenu = true;
		
		Role thisRole = roleDAO.getRoleFromDB(roleID);
		thisRole.setRoleName(roleName);	
		roleDAO.updateRoles(thisRole);
		return loopRecordMenu;		
	}
	
	public void displayEmployeeRole(Integer employeeID){
			Employee employee = personDAO.getEmployeeRecord(employeeID);
			
			Set roles = employee.getRole();			
			Name name = employee.getName();			
			
			System.out.println("\n\t\tID   Name");
			System.out.println("\t\t" + employee.getId() + "  " + name.getFirstName() + " " + name.getMiddleName() + " " + name.getLastName());
			System.out.println("\n\t\tROLES");
			for(Iterator roleIterator = roles.iterator(); roleIterator.hasNext();){
				Role role = (Role)roleIterator.next();
				System.out.println("\t\t[" + role.getId() + "] " + role.getRoleName());
			}
	}
	
	public boolean roleList(){
		boolean loopRoleMenu = true;
		
		List roleList = roleDAO.getRoleList();
		System.out.println("\n\t\tROLES");
		for(Iterator roleIterator = roleList.iterator(); roleIterator.hasNext();){
				Role role = (Role)roleIterator.next();
			
				System.out.println("\t\t[" + role.getId() + "] " + role.getRoleName());
		}	
		
		return loopRoleMenu;			
	}
	
	public void roleList(List roleList){	
		for(Iterator roleIterator = roleList.iterator(); roleIterator.hasNext();){
				Role role = (Role)roleIterator.next();
		
				System.out.println("\t[" + role.getId() + "] " + role.getRoleName());
		}	
	}
	
	public boolean displayRoleEmployeesList(){
		boolean loopRoleMenu = true;
		
		List roleList = roleDAO.getRoleList();
		System.out.println("");
		for(Iterator roleIterator = roleList.iterator(); roleIterator.hasNext();){
			Role role = (Role)roleIterator.next();
			System.out.println("\t[" + role.getId() + "] " + role.getRoleName() + " ");
			Set employees = role.getEmployee();
			List thisRoleEmployees = roleEmployeesToList(employees);
			for(Iterator employeeIterator = thisRoleEmployees.iterator(); employeeIterator.hasNext();){
				String employeeName = (String)employeeIterator.next();
			
				System.out.println("\t\t" + employeeName);
			}
			System.out.println("");
		}
		
		return loopRoleMenu;
	}
	
	public List roleEmployeesToList(Set employees){
		List thisRoleEmployees = new ArrayList();
		
		for(Iterator employeeIterator = employees.iterator(); employeeIterator.hasNext();){
			Employee employee = (Employee)employeeIterator.next();
			Name name = employee.getName();
			thisRoleEmployees.add("[" + employee.getId() + "] " +name.getFirstName() + " " + name.getLastName());
		}
		
		return thisRoleEmployees;
	}		
}
