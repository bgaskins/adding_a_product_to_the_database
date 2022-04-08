<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Product</title>
</head>
<body>

	<h2>Add a Product</h2>
	<h3>Enter all product information:</h3>
	<form action = "addProduct" method = "get">
	Product ID #: <input type = "text" name = "prodId"><br/>
	Product Name: <input type = "text" name = "prodName"><br/>
	Product Price: <input type = "text" name = "prodPrice"><br/>
	<input type = "submit" value = "Submit">
	</form><br><br>
	
	<a href = "productView">View All Products</a>

</body>
</html>