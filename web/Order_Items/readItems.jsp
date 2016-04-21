<%-- 
    Document   : readCustomers
    Created on : Apr 11, 2016, 4:56:50 PM
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
        <h1>Ordered Items</h1>
        <%= table %>
        <a href="addItems">Add a new Ordered Item</a>
        <br>
        <a href="../index.jsp">Back to start page</a>
    </body>
</html>
