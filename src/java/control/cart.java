/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name="cart", urlPatterns={"/cart"})
public class cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        int accountId = ((Account)session.getAttribute("account")).getId();
        ArrayList<BooksInCart> cart = dao.getAllFromCart(accountId);
        ArrayList<Book> books = new ArrayList<>();
        for(BooksInCart bic : cart)
        {
            books.add(dao.getBook(bic.getBookId()));
        }
        request.setAttribute("cart", cart);
        request.setAttribute("books", books);
        dao.close();
        RequestDispatcher dpc = request.getRequestDispatcher("cart.jsp");
        dpc.forward(request, response);
    }
}
