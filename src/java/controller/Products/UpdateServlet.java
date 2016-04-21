/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Products;

import helpers.Products.ProductsUpdate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Products;

/**
 *
 * @author KsS
 */
@WebServlet(name = "ProductsUpdateServlet", urlPatterns = {"/Products/updateProduct"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int product_id=Integer.parseInt(request.getParameter("id"));
        String product_name=request.getParameter("product_name");
        String category=request.getParameter("category");
        int list_price=Integer.parseInt(request.getParameter("list_price"));
        int product_amount=Integer.parseInt(request.getParameter("product_amount"));
        int supplier_id=Integer.parseInt(request.getParameter("supplier_id"));
        
        
        Products product= new Products();
        product.setProduct_id(product_id);
        product.setProduct_name(product_name);
        product.setCategory(category);
        product.setList_price(list_price);
        product.setProduct_amount(product_amount);
        product.setSupplier_id(supplier_id);
             
        
        ProductsUpdate pu= new ProductsUpdate();
        pu.doUpdate(product);
        
        String url="/Products/readProducts";
        
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
