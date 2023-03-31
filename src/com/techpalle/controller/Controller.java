package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.AdminDao;
import com.techpalle.dao.CustomerDao;
import com.techpalle.model.Admin;
import com.techpalle.model.Customer;


@WebServlet("/")
public class Controller extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		switch(path)
		{
		case "/list":
		{
			 validateCustomer(request,response);
				break;
		}
		case "/table":
		{
			getCustomerListPage(request,response);
			break;
		}
		
		case "/delete" :
		{
			deleteCustomer(request,response);
			break;
		}
		
		case "/edit" :
		{
			editCustomer(request,response);
			break;
		}
		
		case "/editForm" :
		{
			getEditForm(request,response);
				break;
		}
		
		case "/insertForm" :
		{
			getInsertForm(request,response);
			break;
		}
		case "/add" :
		{
			addCustomer(request,response);
			break;
		}
		default:
			getStartUpPage(request,response);
			break;
		}
	}
	
	private void getCustomerListPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			    ArrayList<Customer> alCustomer=CustomerDao.getAllCustomers();
				
				RequestDispatcher rd=request.getRequestDispatcher("customer-list.jsp");
				request.setAttribute("al",alCustomer);
			    rd.forward(request, response);
		}  
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the username and password
		String u=request.getParameter("tbUser");
		String p=request.getParameter("tbPass");
		

		// call the dao method to validate admin
		boolean res=AdminDao.validateAdmin(u,p);
		
		// condition to redirect admin to list page
		if(res)
		{
          
			getCustomerListPage(request,response);
		}
		else
		{
			try 
			{
				response.sendRedirect(request.getContextPath() + "/default");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the id from URL
		int i=Integer.parseInt(request.getParameter("id"));
		
		// call the DAO method to delete the row in DB
		CustomerDao.deleteCustomer(i);
		
		// Redirect user to customer-list page
	/*	try
		{
			response.sendRedirect("list");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	*/	
		getCustomerListPage(request,response);
	}
	private void editCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		int i=Integer.parseInt(request.getParameter("tbId"));
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		long m=Long.parseLong(request.getParameter("tbMobile"));
		
		Customer c=new Customer(i,n,e,m);
		CustomerDao.editCustomer(c);
	/*	
		try 
		{
			// Redirect user to customer-list
			response.sendRedirect("list");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	*/	
		getCustomerListPage(request,response);
	}
	private void getEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		// Fetch the Id from URL::
		int i=Integer.parseInt(request.getParameter("id"));
		
		Customer c=CustomerDao.getOneCustomer(i);
		
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer-form.jsp");
			
			request.setAttribute("customer",c);
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
		
	}
	private void getInsertForm(HttpServletRequest request, HttpServletResponse response)
	{
		
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer-form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		Long m=Long.parseLong( request.getParameter("tbMobile"));
		
		// Store the Admin given data into model or object
		Customer c=new Customer(n,e,m);
		
		// insert customer data to DB
		CustomerDao.addCustomer(c);
		
		// Redirect to HomePage
		
		//getStartUpPage(request,response);
		getCustomerListPage(request,response);
		
		
	}
	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response)
	{
		
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("admin-login.jsp");
			rd.forward(request, response);
			
			/*ArrayList<Customer> alCustomer=CustomerDao.getAllCustomers();
			
			RequestDispatcher rd=request.getRequestDispatcher("customer-list.jsp");
			request.setAttribute("al",alCustomer);
			rd.forward(request, response);
			*/
		}
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
