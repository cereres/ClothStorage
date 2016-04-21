<%-- 
    Document   : updateItems
    Created on : Apr 14, 2016, 3:32:59 PM
    Author     : KsS
--%>

<%@page import="helpers.Products.ProductsAdd"%>
<%@page import="java.util.List"%>
<%@page import="helpers.Orders.OrdersAdd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Order_Items"%>
<% Order_Items item = (Order_Items) request.getAttribute("item");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update An Ordered Item</h1>
        <form name="updateForm" action="updateItem" method="get">
            <table class="update">
                <tr>
                <tr>
                    <td class="right">Order Item Id:</td>
                    <td><input type="text" name="id" value="<%=item.getOrder_items_id()%>" readonly></td>
                </tr>

                <td class="right">Order ID:</td>
                <td>
                    <select name="order_id">
                        <option value="<%=item.getOrder_id()%>"><%=item.getOrder_id()%></option>
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
                            <% int l = item.getProduct_id();
                                ProductsAdd pa = new ProductsAdd();
                                String prod_name = pa.findProduct_name(l);%>
                            <option value="<%=item.getProduct_id()%>"><%=prod_name%></option>
                            <%
                                
                                List<Integer> list1 = pa.findID();
                                
                                for (int i = 0; i < list1.size(); i++) {
                                    int k = list1.get(i);
                                    prod_name = pa.findProduct_name(k);
                                    

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
                    <td><input type="text" name="quantity" value="<%=item.getQuantity()%>"/></td>
                </tr>


            </table>

            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>

        </form>
    </body>
</html>
