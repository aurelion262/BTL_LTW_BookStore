/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="removeAccount", urlPatterns={"/removeAccount"})
public class removeAccount extends HttpServlet {

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
        Account sessionAccount = (Account)session.getAttribute("account");
        if(sessionAccount.getRole().equals("ADMIN"))
        {
            try {
                    dao.removeAccount(Integer.parseInt(request.getParameter("id")));
                    
                    String date = Calendar.getInstance().getTime().toString();
                    String action = "REMOVE";
                    int accountId = sessionAccount.getId();
                    Log l = new Log();
                    l.setAccountId(accountId);
                    l.setDate(date);
                    l.setAction(action);
                    l.setObjectId(Integer.parseInt(request.getParameter("id")));
                    l.setObjectType("ACCOUNT");
                    dao.addLog(l);
                    
                    response.sendRedirect("accountList");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else
        {
            response.sendRedirect("index");
        }
        dao.close();
    }
}
