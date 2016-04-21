<%-- 
    Document   : updateCustomers
    Created on : Apr 11, 2016, 8:33:10 PM
    Author     : KsS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customer= (Customers) request.getAttribute("customer");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Customer</title>
        
    </head>
    <body>
        <h1>Update A Customer Record</h1>
        <form name="updateForm" action="updateCustomer" method="get">
            <table class="update">
                
                 <tr>
                    <td class="right">Customer ID:</td>
                    <td><input type="text" name="id" value="<%=customer.getCustomer_id()%>" readonly></td>
                </tr>
                               
                <tr>
                    <td class="right">Organization Name:</td>
                    <td><input type="text" name="organization_name" value="<%=customer.getOrganization_name()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Person in charge:</td>
                    <td><input type="text" name="person_in_charge" value="<%=customer.getPerson_in_charge()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Bank account:</td>
                    <td><input type="text" name="bank_account" value="<%=customer.getBank_account()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Adress:</td>
                    <td><input type="text" name="adress" value="<%=customer.getAdress()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Phone number:</td>
                    <td><input type="text" name="phone_number" value="<%=customer.getPhone_number()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Email:</td>
                    <td><input type="text" name="email" value="<%=customer.getEmail()%>"/></td>
                </tr>
            </table>

                <br>
                    <input type="reset" name="reset" value="Clear"/>
                    <input type="submit" name="submit" value="Update"/>
                
        </form>
    </body>
</html>
