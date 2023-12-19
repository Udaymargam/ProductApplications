package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String 	proId=request.getParameter("proId");
	
	ProductDao dao=new ProductDao();
	int deleteresult=dao.deletebyProductID(proId);
	if(deleteresult==1)
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("listOfProducts.jsp");
		dispatcher.forward(request, response);
	}
	}
}
