<%@page import="com.sathya.servlet.Product"%>
<%@page import="com.sathya.servlet.ProductDao"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>List of Products</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

<h1>List of Products</h1>

<a class="btn btn-success mt-5" href="saveproduct.html">
  			  Save Product
</a>

<table class="table table-bordered table-striped">
    <thead class="thead-dark">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Cost</th>
            <th>Brand</th>
            <th>Made In</th>
            <th>Manufacture Date</th>
            <th>Expiry Date</th>
            <th>Image</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="product" 
        	items="<%=new ProductDao().displayListOfProducts()%>">
            <tr>
                <td>${product.proId}</td>
                <td>${product.proName}</td>
                <td>${product.proPrice}</td>
                <td>${product.proBrand}</td>
                <td>${product.proMadeIn}</td>
                <td>${product.proMfgDate}</td>
                <td>${product.proExpDate}</td>           
                <td>
   			<img src="data:image/jpeg;base64,${product.base64ProductImage}" alt="Product Image" style="max-width: 100px; max-height: 100px;">
				</td>
                <td>
                   <a class="btn btn-info"  href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
                   <a class="btn btn-info" href="./EditProductServlet?proId=${product.proId}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>