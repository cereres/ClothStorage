/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Suppliers;


import helpers.Suppliers.SuppliersAdd;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Suppliers;


/**
 *
 * @author KsS
 */
@WebServlet(name = "SuppliersAddServlet", urlPatterns = {"/Suppliers/addSupplier"})
public class AddServlet extends HttpServlet {

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
            out.println("<title>Servlet SuppliersAddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SuppliersAddServlet at " + request.getContextPath() + "</h1>");
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
        
        String organization_name=request.getParameter("organization_name");
        String person_in_charge=request.getParameter("person_in_charge");
        String adress=request.getParameter("adress");
        Long phone_number=Long.parseLong(request.getParameter("phone_number"));
        String email=request.getParameter("email");
        
        Suppliers supplier = new Suppliers();
        supplier.setOrganization_name(organization_name);
        supplier.setPerson_in_charge(person_in_charge);
        
        supplier.setAdress(adress);
        supplier.setPhone_number(phone_number);
        supplier.setEmail(email);
        
       SuppliersAdd sa= new SuppliersAdd();
        sa.doAdd(supplier);
        
        String url="/Suppliers/readSuppliers";
        
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
