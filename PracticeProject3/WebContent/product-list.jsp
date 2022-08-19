<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Product List</title>
</head>
<body>
 <center>
  <h1>Product</h1>
        <h2>
         <a href="new">Add New Product</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Product</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Products</h2></caption>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
            </tr>
            <c:forEach var="pr" items="${listProduct}">
                <tr>
                    <td><c:out value="${pr.id}" /></td>
                    <td><c:out value="${pr.name}" /></td>
                    <td><c:out value="${pr.price}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${pr.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${pr.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>