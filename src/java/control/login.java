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
@WebServlet(name="login", urlPatterns={"/login"})

public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = new DAO().getAccount((String)request.getParameter("username"),
                                           (String)request.getParameter("password"));
            if(a!=null)
            {
                session.setAttribute("account", a);
                RequestDispatcher dpc = request.getRequestDispatcher("index");
                dpc.forward(request, response);
            }
            else
            {
                request.setAttribute("message","Nhập sai tên tài khoản/mật khẩu. Vui lòng nhập lại !");
                RequestDispatcher dpc = request.getRequestDispatcher("login.jsp");
                dpc.forward(request, response);
            }
    }
}
