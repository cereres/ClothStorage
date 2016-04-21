<%-- 
    Document   : addCustomers
    Created on : Apr 11, 2016, 6:30:26 PM
    Author     : KsS
--%>


<%@page import="helpers.Products.ProductsAdd"%>
<%@page import="helpers.Orders.OrdersAdd"%>
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
        <h1>Add A New Ordered Item</h1>
        <form name="addForm" action="addItem" method="get">
            <table class="add">
                <tr>
                    <td class="right">Order ID:</td>
                    <td>
                        <select name="order_id">
                            <option value="">Choose an order...</option>
                            <%
                                OrdersAdd oa = new OrdersAdd();
                                List<Integer> list = oa.findID();

                                for (int i = 0; i < list.size(); i++) {
                                    int k = list.get(i);
                                    


                            %>
                            <option value=<%=k%>><%=k%></option>
                            <%

                                }
                            %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="right">Product ID:</td>
                    <td>
                        <select name="product_id">
                            <option value="">Choose a product...</option>
                            <%
                                ProductsAdd pa = new ProductsAdd();
                                List<Integer> list1 = pa.findID();
                                

                                for (int i = 0; i < list1.size(); i++) {
                                    int k = list1.get(i);
                                    String prod_name = pa.findProduct_name(k);


                            %>
                            <option value=<%=k%>><%=prod_name%></option>
                            <%

                                }
                            %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="right">Quantity:</td>
                    <td><input type="text" name="quantity" value=""/></td>
                </tr>


            </table>

            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Add"/>

        </form>
    </body>
</html>
