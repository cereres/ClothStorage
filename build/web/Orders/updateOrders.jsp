<%-- 
    Document   : updateOrders
    Created on : Apr 14, 2016, 1:54:27 PM
    Author     : KsS
--%>

<%@page import="java.util.List"%>
<%@page import="helpers.Customers.CustomersAdd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Orders"%>
<% Orders order= (Orders) request.getAttribute("order");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Update an Order</h1>
        <form name="updateForm" action="updateOrder" method="get">
            <table class="update">
                
                <tr>
                    <td class="right">Order ID:</td>
                    <td><input type="text" name="id" value="<%=order.getOrder_id()%>" readonly></td>
                </tr>


                <tr>
                    <td class="right">Customer ID:</td>
                    <td>
                        <select name="customer_id">
                            <option value="<%=order.getCustomer_id()%>"><%=order.getCustomer_id()%></option>
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
                    <td><input type="text" name="total_sum" value="<%=order.getTotal_sum()%>"/></td>
                </tr>

               
            </table>

            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>

        </form>
    </body>
</html>
