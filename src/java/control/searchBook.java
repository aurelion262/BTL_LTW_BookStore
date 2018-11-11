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
            String searchOption;
            String bookName;
            String author;
            String category;
            if(request.getParameter("searchOption")!=null)
            {
                searchOption = request.getParameter("searchOption");
                bookName = request.getParameter("bookName");
                author = request.getParameter("author");
                category = request.getParameter("category");
            }
            else
            {
                searchOption = (String)session.getAttribute("searchOption");
                bookName = (String)session.getAttribute("bookName");
                author = (String)session.getAttribute("author");
                category = (String)session.getAttribute("category");
            }
            
            if(searchOption.equals("name"))
            {
                bookList = dao.getBookByName(bookName);
                session.setAttribute("bookName", bookName);
            }
            if(searchOption.equals("author"))
            {
                bookList = dao.getBookByAuthor(author);
                session.setAttribute("author", author);
            }
            if(searchOption.equals("category"))
            {
                bookList = dao.getBookByCategory(category);
                session.setAttribute("category", category);
            }
            if(searchOption.equals("finalPrice"))
            {
                int floorPrice = Integer.parseInt(request.getParameter("floorPrice"));
                int ceilingPrice = Integer.parseInt(request.getParameter("ceilingPrice"));
                session.setAttribute("ceilingPrice", ceilingPrice);
                session.setAttribute("floorPrice", floorPrice);
                bookList = dao.getBook(floorPrice, ceilingPrice);
            }
            request.setAttribute("bookList", bookList);
            session.setAttribute("searchOption", searchOption);   
            dao.close();
            RequestDispatcher dpc = request.getRequestDispatcher("searchBook.jsp");
            dpc.forward(request, response);
    }
}
