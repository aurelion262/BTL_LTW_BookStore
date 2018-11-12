package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.DAO;
import model.Log;
import model.Order;

@WebServlet(name="isPaid", urlPatterns={"/isPaid"})
public class isPaid extends HttpServlet {

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
        
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        if(sessionAccount.getRole().equals("ADMIN"))
        {
            Order o = dao.getOrder(orderId);
            if(o.getIsPaid()==0)
            {                
                dao.isPaid(orderId, 1);
                
                    String date = Calendar.getInstance().getTime().toString();
                    String action = "EDIT";
                    int accountId = sessionAccount.getId();
                    Log l = new Log();
                    l.setAccountId(accountId);
                    l.setDate(date);
                    l.setAction(action);
                    l.setObjectId(orderId);
                    l.setObjectType("ORDER");
                    l.setDetail("\"isPaid\" changed from 0 to 1");
                    dao.addLog(l);
                
            }
            else
            {
                dao.isPaid(orderId, 0);
                
                    String date = Calendar.getInstance().getTime().toString();
                    String action = "EDIT";
                    int accountId = sessionAccount.getId();
                    Log l = new Log();
                    l.setAccountId(accountId);
                    l.setDate(date);
                    l.setAction(action);
                    l.setObjectId(orderId);
                    l.setObjectType("ORDER");
                    l.setDetail("\"isPaid\" changed from 1 to 0");
                    dao.addLog(l);
                
            }
        }
        dao.close();
        response.sendRedirect("orderList");
    }
}
