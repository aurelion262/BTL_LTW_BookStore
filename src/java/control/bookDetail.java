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
import model.Book;
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="bookDetail", urlPatterns={"/bookDetail"})
public class bookDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        Book b = new DAO().getBook(bookId);
        request.setAttribute("book", b);
        RequestDispatcher dpc = request.getRequestDispatcher("bookDetail.jsp");
        dpc.forward(request, response);
    }
}
