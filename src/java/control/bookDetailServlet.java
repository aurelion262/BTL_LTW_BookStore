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
@WebServlet(name="bookDetailServlet", urlPatterns={"/bookDetailServlet"})
public class bookDetailServlet extends HttpServlet {

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
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        DAO dao = new DAO();
        Book b = dao.getBook(bookId);
        request.setAttribute("book", b);
        dao.close();
        RequestDispatcher dpc = request.getRequestDispatcher("bookDetail.jsp");
        dpc.forward(request, response);
    }
}
