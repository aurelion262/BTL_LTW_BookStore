/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
        {
            try {
                    dao.removeAccount(Integer.parseInt(request.getParameter("id")));
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
