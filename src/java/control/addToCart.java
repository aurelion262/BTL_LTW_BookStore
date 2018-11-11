/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Book;
import model.BooksInCart;
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="addToCart", urlPatterns={"/addToCart"})
public class addToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account sessionAccount = (Account)session.getAttribute("account");
        if(sessionAccount!=null)
        {
            int accountId = ((Account)session.getAttribute("account")).getId();
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            BooksInCart bic = new BooksInCart();
            DAO dao = new DAO();
            if(dao.getFromCart(accountId, bookId)!=null)
            {
                bic = dao.getFromCart(accountId, bookId);
                bic.setQuantity(bic.getQuantity()+quantity);
                dao.editBooksInCart(bic);
            }
            else
            {
                bic.setAccountId(accountId);
                bic.setBookId(bookId);
                bic.setQuantity(quantity);
                dao.addToCart(bic);
            }
            dao.close();
            RequestDispatcher dpc = request.getRequestDispatcher("cart");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }
}
