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
import model.Book;
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="searchBook", urlPatterns={"/searchBook"})
public class searchBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            DAO dao = new DAO();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            ArrayList<Book> bookList = new ArrayList<>();
            String searchOption = request.getParameter("searchOption");
            String bookName = request.getParameter("bookName");
            String author = request.getParameter("author");
            String category = request.getParameter("category");
            if(searchOption.equals("name"))
            {
                bookList = dao.getBookByName(bookName);
            }
            if(searchOption.equals("author"))
            {
                bookList = dao.getBookByAuthor(author);
            }
            if(searchOption.equals("category"))
            {
                bookList = dao.getBookByCategory(category);
            }
            if(searchOption.equals("finalPrice"))
            {
                int floorPrice = Integer.parseInt(request.getParameter("floorPrice"));
                int ceilingPrice = Integer.parseInt(request.getParameter("ceilingPrice"));
                bookList = dao.getBook(floorPrice, ceilingPrice);
            }
            request.setAttribute("bookList", bookList);
            RequestDispatcher dpc = request.getRequestDispatcher("searchBook.jsp");
            dpc.forward(request, response);
    }
}
