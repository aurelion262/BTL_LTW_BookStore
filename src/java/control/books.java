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
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="books", urlPatterns={"/books"})
public class books extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            HttpSession session = request.getSession();
            DAO dao = new DAO();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            ArrayList<Book> bookList = new ArrayList<>();
            String category = request.getParameter("category");
            bookList = dao.getBookByCategory(category);
            request.setAttribute("bookList", bookList);
            dao.close();
            RequestDispatcher dpc = request.getRequestDispatcher("books.jsp");
            dpc.forward(request, response);
    }
}
