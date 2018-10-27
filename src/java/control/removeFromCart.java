/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="removeFromCart", urlPatterns={"/removeFromCart"})
public class removeFromCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        new DAO().removeFromCart(accountId, bookId);
        response.sendRedirect("cart");
    }
}
