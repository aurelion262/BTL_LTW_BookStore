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
import model.Log;

@WebServlet(name="viewLog", urlPatterns={"/viewLog"})
public class viewLog extends HttpServlet {

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
        Account sessionAccount = (Account)session.getAttribute("account");
        if(sessionAccount.getRole().equals("ADMIN"))
        {        
            ArrayList<Log> logList = dao.getLog();
            request.setAttribute("logList", logList);
            RequestDispatcher dpc = request.getRequestDispatcher("log.jsp");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("indexServlet");
        }
    }
}
