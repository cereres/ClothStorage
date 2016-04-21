<%-- 
    Document   : addCustomers
    Created on : Apr 11, 2016, 6:30:26 PM
    Author     : KsS
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="helpers.Suppliers.SuppliersAdd"%>
<%@page import="model.Suppliers"%>
<%@page import="helpers.Products.ProductsAdd"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add A New Product</h1>
        <form name="addForm" action="addProduct" method="get">
            <table class="add">


                <tr>
                    <td class="right">Product Name:</td>
                    <td><input type="text" name="product_name" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Category:</td>
                    <td>
                        <select name="category">
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
                    <td><input type="text" name="list_price" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Product amount:</td>
                    <td><input type="text" name="product_amount" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Supplier ID:</td>
                    <td>
                        <select name="supplier_id">
                            <option value="">Choose a supplier...</option>
                            <%
                                SuppliersAdd sa = new SuppliersAdd();
                                List<Integer> list=sa.findID();
                                
                                
                                
                                for (int i = 0; i < list.size(); i++) {
                                    int k=list.get(i);
                                    String org_name=sa.findOrganization_name(k);
                                    
                                    
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
            <input type="submit" name="submit" value="Add"/>

        </form>
    </body>
</html>
