<%-- 
    Document   : addCustomers
    Created on : Apr 11, 2016, 6:30:26 PM
    Author     : KsS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Add A New Customer</h1>
       <form name="addForm" action="addSupplier" method="get">
            <table class="add">
                
                               
                <tr>
                    <td class="right">Organization Name:</td>
                    <td><input type="text" name="organization_name" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Person in charge:</td>
                    <td><input type="text" name="person_in_charge" value=""/></td>
                </tr>

               

                <tr>
                    <td class="right">Adress:</td>
                    <td><input type="text" name="adress" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Phone number:</td>
                    <td><input type="text" name="phone_number" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Email:</td>
                    <td><input type="text" name="email" value=""/></td>
                </tr>
            </table>

                <br>
                    <input type="reset" name="reset" value="Clear"/>
                    <input type="submit" name="submit" value="Add"/>
                
        </form>
    </body>
</html>
