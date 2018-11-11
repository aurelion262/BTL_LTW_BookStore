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
import model.DAO;
import model.Feedback;

@WebServlet(name="doFeedback", urlPatterns={"/doFeedback"})
public class doFeedback extends HttpServlet {

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
            String name,message;
            int accountId;
            name = request.getParameter("name");
            message = request.getParameter("message");
            if(!request.getParameter("accountId").equals("")) accountId = Integer.parseInt(request.getParameter("accountId"));
            String reply="";
            Account sessionAccount = (Account)session.getAttribute("account");
            if(sessionAccount==null)
            {                
                dao.sendFeedback(name,message);
            }
            else
            {
                Feedback f = new Feedback();
                f.setName(name);
                f.setAccountId(accountId);
                f.setMessage(message);
                dao.sendFeedback(f);
            }
            reply="Gửi thành công. Xin chân thành cảm ơn góp ý của bạn !";
            request.setAttribute("reply", reply);
            dao.close();
            RequestDispatcher dpc = request.getRequestDispatcher("feedBack.jsp");
            dpc.forward(request, response);
    }
}
