package com.sathya.servlet;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
public class ProductDao 
{
    // Method to insert a product with an image into the database
    public int saveProduct(Product product) throws ServletException, SQLException {
        Connection connection = null;
        PreparedStatement  preparedStatement=null;
        int saveresult=0;
        String sql = "INSERT INTO Products VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try { 
            connection=DatabaseUtils.createConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProId());
            preparedStatement.setString(2, product.getProName());
            preparedStatement.setDouble(3, product.getProPrice());
            preparedStatement.setString(4, product.getProBrand());
            preparedStatement.setString(5, product.getProMadeIn());
            preparedStatement.setDate(6, product.getProMfgDate());
            preparedStatement.setDate(7, product.getProExpDate());
            preparedStatement.setBinaryStream(8, product.getProImage());
            saveresult= preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Database operation failed", e);
        }
        finally
        {
        	try {
        		if(connection!=null) connection.close();
        		if(preparedStatement!=null) preparedStatement.close();
        	}
        	catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
		return saveresult;
    }

    // Method to retrieve all products from the database
    public List<Product> displayListOfProducts() throws ServletException, SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = DatabaseUtils.createConnection();
        String sql = "SELECT * FROM Products";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String proId = resultSet.getString("proId");
                String proName = resultSet.getString("proName");
                double proPrice = resultSet.getDouble("proPrice");
                String proBrand = resultSet.getString("proBrand");
                String proMadeIn = resultSet.getString("proMadeIn");
                Date proMfgDate = resultSet.getDate("proMfgDate");
                Date proExpDate = resultSet.getDate("proExpDate");
                InputStream proImage = resultSet.getBinaryStream("proImage");
                
                Product product=new Product();
                product.setProId(resultSet.getString(1));
                product.setProName(resultSet.getString(2));
                product.setProPrice(resultSet.getDouble(3));
                product.setProBrand(resultSet.getString(4));
                product.setProMadeIn(resultSet.getString(5));
                product.setProMfgDate(resultSet.getDate(6));
                product.setProExpDate(resultSet.getDate(7));
                product.setProImage(resultSet.getBinaryStream(8));
                productList.add(product);
               
            }
        } catch (SQLException e) {
            throw new ServletException("Database operation failed", e);
        }
        return productList;
    }
    public int deletebyProductID(String proId) {
    	Connection connection = null;
        PreparedStatement  preparedStatement=null;
        int deleteresult=0;
        String sql = "delete from Products where proId=?";
        try { 
            connection=DatabaseUtils.createConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,proId);
            deleteresult= preparedStatement.executeUpdate();
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
		return deleteresult;
    	
    }
    public Product updateByProId(String proId) 
     {
    	Connection connection = null;
        PreparedStatement  preparedStatement=null;
        Product product=null;
        String sql = "select * from Products where proId=?";
        try 
        {
        	connection=DatabaseUtils.createConnection();
        	preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, proId);
            ResultSet resultSet=preparedStatement.executeQuery();
        	if(resultSet.next()) {
        	    product=new Product();
        		product.setProId(resultSet.getString(1));
                product.setProName(resultSet.getString(2));
                product.setProPrice(resultSet.getDouble(3));
                product.setProBrand(resultSet.getString(4));
                product.setProMadeIn(resultSet.getString(5));
                product.setProMfgDate(resultSet.getDate(6));
                product.setProExpDate(resultSet.getDate(7));
                product.setProImage(resultSet.getBinaryStream(8));
        	}
        }
    	catch(SQLException e) 
        {
    		e.printStackTrace();
    	}
		return product;
     }
    public int updateProduct(Product updatedProduct) {
	    int result = 0;
	    Connection connection =null;
	    PreparedStatement preparedStatement=null;
	        try {
	        connection = DatabaseUtils.createConnection();
	        
	        String sql = "UPDATE products SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
                    "proMfgDate=?, proExpDate=?, proImage=? WHERE proId=?";
            
             preparedStatement = connection.prepareStatement(sql);
                // Set the parameters for the update statement
            preparedStatement.setString(1, updatedProduct.getProName());
            preparedStatement.setDouble(2, updatedProduct.getProPrice());
            preparedStatement.setString(3, updatedProduct.getProBrand());
            preparedStatement.setString(4, updatedProduct.getProMadeIn());
            preparedStatement.setDate(5, updatedProduct.getProMfgDate());
            preparedStatement.setDate(6, updatedProduct.getProExpDate());
            preparedStatement.setBinaryStream(7, updatedProduct.getProImage());
            preparedStatement.setString(8, updatedProduct.getProId());
	                // Execute the update
	            result = preparedStatement.executeUpdate();
		        // Commit changes after successful update
		        connection.commit();
	            }
	            catch (SQLException e)
	           {
	            e.printStackTrace();   
	           } 
	           finally
	           {
	        	 try 
	        	 {
	        		if(connection!=null) connection.close();
	        		if(preparedStatement!=null) preparedStatement.close();
	        	 }
	        	 catch(SQLException e) 
	        	 {
	        		e.printStackTrace();
	        	 }
	          }
	        return result;
	    }
    }


