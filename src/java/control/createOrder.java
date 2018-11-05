
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.BooksInCart;
import model.BooksInOrder;
import model.DAO;
import model.Order;


@WebServlet(name = "createOrder", urlPatterns = {"/createOrder"})
public class createOrder extends HttpServlet {

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
        Account sessionAccount = (Account)session.getAttribute("account");
        DAO dao = new DAO();
        Order o = new Order();
        o.setCreatedDate(Calendar.getInstance().getTime().toString());
        o.setAccountId(sessionAccount.getId());
        o.setAddress(request.getParameter("address"));
        o.setClientName(request.getParameter("clientName"));
        o.setPhoneNumber(request.getParameter("phoneNumber"));
        o.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
        dao.createOrder(o);
        ArrayList<BooksInCart> bicList = dao.getAllFromCart(sessionAccount.getId());
        for(BooksInCart bic : bicList)
        {
            BooksInOrder bio = new BooksInOrder();
            bio.setBookId(bic.getBookId());
            bio.setOrderId(dao.getLastOrder(sessionAccount.getId()).getId());
            bio.setQuantity(bic.getQuantity());
            dao.addToOrder(bio);
        }
        dao.removeAllFromCart(sessionAccount.getId());
        response.sendRedirect("orderHistory");
    }
}
