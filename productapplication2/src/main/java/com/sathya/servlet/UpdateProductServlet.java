package com.sathya.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proId = request.getParameter("proId");
        String updatedProductName = request.getParameter("proName");
        double updatedProductPrice = Double.parseDouble(request.getParameter("proPrice"));
        String updatedProductBrand = request.getParameter("proBrand");
        String updatedProductMadeIn = request.getParameter("proMadeIn");
        Date updatedProductMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
        Date updatedProductExpDate = Date.valueOf(request.getParameter("proExpDate"));
     
         Product product = new Product();
	     product.setProId(proId);
	     product.setProName(updatedProductName);
	     product.setProPrice(updatedProductPrice);
	     product.setProBrand(updatedProductBrand);
	     product.setProMadeIn(updatedProductMadeIn);
	     product.setProMfgDate(updatedProductMfgDate);
	     product.setProExpDate(updatedProductExpDate);
	     
	     ProductDao dao = new ProductDao();
	     Part newImagePart = request.getPart("proImage");
	     if (newImagePart != null && newImagePart.getSize() > 0) {
	            product.setProImage(newImagePart.getInputStream());
	        } else {
	        	 Product existingProduct = dao.updateByProId(proId);
	        	
	            product.setProImage(existingProduct.getProImage());
	        }
	     int result = dao.updateProduct(product);
	
	     if(result == 1)
	     {  	RequestDispatcher dispatcher = request.getRequestDispatcher("listOfProducts.jsp");
	        	dispatcher.forward(request, response);
	     }    
	    
	}
	}
