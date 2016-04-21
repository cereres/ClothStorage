<%-- 
    Document   : addCustomers
    Created on : Apr 11, 2016, 6:30:26 PM
    Author     : KsS
--%>

<%@page import="helpers.Customers.CustomersAdd"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add A New Product</h1>
        <form name="addForm" action="addOrder" method="get">
            <table class="add">


                <tr>
                    <td class="right">Customer ID:</td>
                    <td>
                        <select name="customer_id">
                            <option value="">Choose a customer...</option>
                            <%
                                CustomersAdd ca = new CustomersAdd();
                                List<Integer> list=ca.findID();
                                
                                
                                
                                for (int i = 0; i < list.size(); i++) {
                                    int k=list.get(i);
                                    String org_name=ca.findOrganization_name(k);
                                    
                                    
                                        %>
                            <option value=<%=k%>><%=org_name%></option>
                            <%

                                }
                            %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td class="right">Total Sum:</td>
                    <td><input type="text" name="total_sum" value=""/></td>
                </tr>

               
            </table>

            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Add"/>

        </form>
    </body>
</html>
