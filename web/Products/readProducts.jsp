<%-- 
    Document   : readProducts
    Created on : Apr 13, 2016, 5:00:30 PM
    Author     : KsS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <% String table=(String)request.getAttribute("table");%>
    <body>
       <h1>Products</h1>
        <%= table %>
        <a href="addProducts">Add a new Product</a>
        <br>
        <a href="../index.jsp">Back to start page</a>
    </body>
</html>
