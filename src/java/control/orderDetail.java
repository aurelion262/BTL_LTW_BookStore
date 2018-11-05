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
import model.BooksInOrder;
import model.DAO;
import model.Order;

@WebServlet(name="orderDetail", urlPatterns={"/orderDetail"})
public class orderDetail extends HttpServlet {

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
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        if(session.getAttribute("account")!=null)
        {
            Account sessionAccount = (Account)session.getAttribute("account");
            Order o = new DAO().getOrder(orderId);
            ArrayList<BooksInOrder> bioList = new DAO().getAllFromOrder(orderId);
            ArrayList<Book> books = new ArrayList<>();
            for(BooksInOrder bio : bioList)
            {
                books.add(new DAO().getBook(bio.getBookId()));
            }
            request.setAttribute("order", o);
            request.setAttribute("bioList", bioList);
            request.setAttribute("books", books);
            RequestDispatcher dpc = request.getRequestDispatcher("orderDetail.jsp");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("index");
        }

    }
}
