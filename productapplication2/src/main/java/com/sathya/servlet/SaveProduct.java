package com.sathya.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/SaveProduct")
@MultipartConfig(maxFileSize = 16177215) // 16 MB
public class SaveProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        double proPrice = Double.parseDouble(request.getParameter("proPrice"));            
        String proBrand = request.getParameter("proBrand");
        String proMadeIn = request.getParameter("proMadeIn");
        Date proMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
        Date proExpDate = Date.valueOf(request.getParameter("proExpDate"));
      

        // Process image file
        Part filePart = request.getPart("proImage");
        InputStream proImage = filePart.getInputStream();
        
        Product product=new Product();
        product.setProId(proId);
        product.setProName(proName);
        product.setProPrice(proPrice);
        product.setProBrand(proBrand);
        product.setProMadeIn(proMadeIn);
        product.setProMfgDate(proMfgDate);
        product.setProExpDate(proExpDate);
        product.setProImage(proImage);
        
        ProductDao dao=new ProductDao();
        int saveresult=0;
	    try 
	    {
		saveresult = dao.saveProduct(product);
	    } 
	    catch (SQLException e) {
		e.printStackTrace();
	    } 
        if(saveresult==1)
        {
    	   RequestDispatcher dispatcher=request.getRequestDispatcher("listOfProducts.jsp");
    	   dispatcher.forward(request, response);
        }
        else 
        {
    	   PrintWriter writer=response.getWriter();
    	   writer.println("<b> product not saved please check once</b>");
    	   RequestDispatcher dispatcher=request.getRequestDispatcher("saveproduct.html");
    	   dispatcher.include(request, response);
        }
}
}