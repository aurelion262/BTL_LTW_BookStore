/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jichu
 */
@WebServlet(name = "orderList", urlPatterns = {"/orderList"})
public class orderList extends HttpServlet {

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
        if(session.getAttribute("account")!=null && ((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
        {
            Account sessionAccount = (Account)session.getAttribute("account");        
            ArrayList<Order> orderList = new DAO().getAllOrder();
            request.setAttribute("orderList", orderList);
            RequestDispatcher dpc = request.getRequestDispatcher("orderList.jsp");
            dpc.forward(request, response);
        }
        else
        {
            response.sendRedirect("index");
        }
    }

}
