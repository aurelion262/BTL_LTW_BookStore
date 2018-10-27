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
@WebServlet(name="editAccount", urlPatterns={"/editAccount"})
public class editAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String message="";
            if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN")
             ||((Account)(session.getAttribute("account"))).getId()==Integer.parseInt(request.getParameter("id")))
            {
                String name = request.getParameter("name"),
                       username = request.getParameter("username"),
                       password = request.getParameter("password"),
                       repassword = request.getParameter("repassword"),
                       email = request.getParameter("email"),
                       address = request.getParameter("address"),
                       phonenumber = request.getParameter("phonenumber"),
                       creditcard = request.getParameter("creditcard"),
                       role = request.getParameter("role");
                int id = Integer.parseInt((String)request.getParameter("id"));
                Account a = new Account();
                a.setId(id);
                a.setName(name);
                a.setCreditcard(creditcard);
                a.setEmail(email);
                a.setPassword(password);
                a.setPhonenumber(phonenumber);
                if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
                {
                    a.setRole(role);
                }
                else
                {
                    a.setRole("CLIENT");
                }
                a.setUsername(username);
                a.setAddress(address);
                new DAO().editAccount(a);
                message+="Cập nhật thành công </br>";
                request.setAttribute("message", message);
                RequestDispatcher dpc = request.getRequestDispatcher("editAccount.jsp?id="+id);
                dpc.forward(request, response);
            }
    }
}
