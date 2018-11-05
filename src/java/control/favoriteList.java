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
import model.BooksInFavorite;
import model.DAO;

@WebServlet(name="favoriteList", urlPatterns={"/favoriteList"})
public class favoriteList extends HttpServlet {

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
        if(session.getAttribute("account")!=null)
        {
            Account sessionAccount = (Account)session.getAttribute("account");
            ArrayList<BooksInFavorite> bifList = new DAO().getAllFromFavorite(sessionAccount.getId());  
            ArrayList<Book> books = new ArrayList<>();
            for(BooksInFavorite bif : bifList)
            {
                books.add(new DAO().getBook(bif.getBookId()));
            }
            request.setAttribute("books", books);
            request.setAttribute("favoriteList", bifList);
            RequestDispatcher dpc = request.getRequestDispatcher("favoriteList.jsp");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("index");
        }
    }
}
