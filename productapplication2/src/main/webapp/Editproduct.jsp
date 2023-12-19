<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<body class="bg-warning">
    
    <div class="container mt-5 text-center">

		<h2 class="text-center font-italic mb-5">Updating product process</h2>

    	<form method="post" action="./UpdateProductServlet"  enctype="multipart/form-data" >
        
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proId">Product ID:</label>
                <input type="text" class="form-control-sm" id="proId" name="proId"  value="${product.proId}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold"  for="proName">Product Name:</label>
                <input type="text" class="form-control-sm" id="proName" name="proName" value="${product.proName}"required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proPrice">Price:</label>
                <input type="number" class="form-control-sm" id="proPrice" name="proPrice" step="0.01" value="${product.proPrice}"   required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proBrand">Brand:</label>
                <input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${product.proBrand}"    required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold"  for="proMadeIn">Made In:</label>
                <input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn"   value="${product.proMadeIn}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold"   for="proMfgDate">Manufacturing Date:</label>
                <input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate"   value="${product.proMfgDate}"  required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold"   for="proExpDate">Expiry Date:</label>
                <input type="date" class="form-control-sm" id="proExpDate" name="proExpDate"  value="${product.proExpDate}" required>
            </div>

            <div class="form-group">
                <label class="font-italic font-weight-bold" for="proImage">Product Image:</label>
                <input type="file" class="form-control-file-sm" id="proImage" name="proImage" accept="image/*"  value="${product.proImage}"  required>
            </div>

            <button type="submit" class="btn btn-primary">Update Product</button>
        </form>
    </div>
</body>
</html>