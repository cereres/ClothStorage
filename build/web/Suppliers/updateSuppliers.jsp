<%-- 
    Document   : updateCustomers
    Created on : Apr 11, 2016, 8:33:10 PM
    Author     : KsS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Suppliers"%>
<% Suppliers supplier= (Suppliers) request.getAttribute("supplier");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Supplier</title>
        
    </head>
    <body>
        <h1>Update A Customer Record</h1>
        <form name="updateForm" action="updateSupplier" method="get">
            <table class="update">
                
                 <tr>
                    <td class="right">Customer ID:</td>
                    <td><input type="text" name="id" value="<%=supplier.getSupplier_id()%>" readonly></td>
                </tr>
                               
                <tr>
                    <td class="right">Organization Name:</td>
                    <td><input type="text" name="organization_name" value="<%=supplier.getOrganization_name()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Person in charge:</td>
                    <td><input type="text" name="person_in_charge" value="<%=supplier.getPerson_in_charge()%>"/></td>
                </tr>

                

                <tr>
                    <td class="right">Adress:</td>
                    <td><input type="text" name="adress" value="<%=supplier.getAdress()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Phone number:</td>
                    <td><input type="text" name="phone_number" value="<%=supplier.getPhone_number()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Email:</td>
                    <td><input type="text" name="email" value="<%=supplier.getEmail()%>"/></td>
                </tr>
            </table>

                <br>
                    <input type="reset" name="reset" value="Clear"/>
                    <input type="submit" name="submit" value="Update"/>
                
        </form>
    </body>
</html>
