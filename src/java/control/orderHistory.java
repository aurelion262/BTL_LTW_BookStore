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
import model.DAO;
import model.Order;

@WebServlet(name="orderHistory", urlPatterns={"/orderHistory"})
public class orderHistory extends HttpServlet {

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
        if(session.getAttribute("account")!=null)
        {
            Account sessionAccount = (Account)session.getAttribute("account");        
            ArrayList<Order> orderList = dao.getAllOrder(sessionAccount.getId());
            request.setAttribute("orderList", orderList);
            RequestDispatcher dpc = request.getRequestDispatcher("orderHistory.jsp");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("index");
        }
        dao.close();
    }
}
