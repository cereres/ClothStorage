<%-- 
    Document   : addCustomers
    Created on : Apr 11, 2016, 6:30:26 PM
    Author     : KsS
--%>




<%@page import="java.util.List"%>
<%@page import="helpers.Suppliers.SuppliersAdd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Products"%>
<% Products product= (Products) request.getAttribute("product");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a Product</h1>
        <form name="updateForm" action="updateProduct" method="get">
            <table class="update">
                
                <tr>
                    <td class="right">Product ID:</td>
                    <td><input type="text" name="id" value="<%=product.getProduct_id()%>" readonly></td>
                </tr>


                <tr>
                    <td class="right">Product Name:</td>
                    <td><input type="text" name="product_name" value="<%=product.getProduct_name()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Category:</td>
                    <td>
                        <select name="category">
                            <option value="<%=product.getCategory()%>"><%=product.getCategory()%></option>
                            <option value="Mens">Mens</option>
                            <option value="Womens">Womens</option>
                            <option value="Kids">Kids</option>
                            <option value="Shoes">Shoes</option>
                            <option value="Accessories">Accessories</option>
                        </select>
                    </td>
                </tr>



                <tr>
                    <td class="right">List Price:</td>
                    <td><input type="text" name="list_price" value="<%=product.getList_price()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Product amount:</td>
                    <td><input type="text" name="product_amount" value="<%=product.getProduct_amount()%>"/></td>
                </tr>

                <tr>
                    <td class="right">Supplier ID:</td>
                    <td>
                        <select name="supplier_id">
                            <% int l=product.getSupplier_id();
                            SuppliersAdd sa = new SuppliersAdd();
                            String org_name=sa.findOrganization_name(l);%>
                            <option value="<%=product.getSupplier_id()%>"><%=org_name%></option>
                            <%
                                
                                List<Integer> list=sa.findID();
                                                              
                                
                                for (int i = 0; i < list.size(); i++) {
                                    int k=list.get(i);
                                    org_name=sa.findOrganization_name(k);
                                    
                                    
                                        %>
                            <option value=<%=k%>><%=org_name%></option>
                            <%

                                }
                            %>
                        </select>
                    </td>
                </tr>
            </table>

            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>

        </form>
    </body>
</html>
