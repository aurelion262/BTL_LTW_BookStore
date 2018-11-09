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
import model.DAO;

@WebServlet(name="editBook", urlPatterns={"/editBook"})
public class editBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String message="";
            if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
            {
                int id = Integer.parseInt((String)request.getParameter("id"));
                Book b = new DAO().getBook(id);
                request.setAttribute("book", b);
                RequestDispatcher dpc = request.getRequestDispatcher("editBook.jsp");
                dpc.forward(request, response);
            }
            else
            {
                response.sendRedirect("index");
            }
    }
}
