package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.BooksInFavorite;
import model.DAO;

@WebServlet(name="removeFromFavorite", urlPatterns={"/removeFromFavorite"})
public class removeFromFavorite extends HttpServlet {

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
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        if(session.getAttribute("account")!=null)
        {
            Account sessionAccount = (Account)session.getAttribute("account");
            dao.removeFromFavorite(sessionAccount.getId(),bookId);
            response.sendRedirect("favoriteList");
        }
        else
        {
            response.sendRedirect("index");
        }
        dao.close();
    }
}
