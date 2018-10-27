/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
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
@WebServlet(name="register", urlPatterns={"/register"})
public class register extends HttpServlet {

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
            String name = request.getParameter("name"),
                   username = request.getParameter("username"),
                   password = request.getParameter("password"),
                   repassword = request.getParameter("repassword"),
                   email = request.getParameter("email"),
                   address = request.getParameter("address"),
                   phonenumber = request.getParameter("phonenumber"),
                   creditcard = request.getParameter("creditcard");
            if(new DAO().checkUsername(username).equals("available")
                    &&!username.equals("")
                    &&!password.equals("")
                    &&password.equals(repassword))
            {
                Account a = new Account();
                a.setName(name);
                a.setUsername(username);
                a.setPassword(password);
                a.setAddress(address);
                a.setPhonenumber(phonenumber);
                a.setCreditcard(creditcard);
                a.setEmail(email);
                new DAO().addAccount(a);
                session.setAttribute("account", new DAO().getAccount(a.getUsername()));
                RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
                dpc.forward(request, response);
            }
            else
            {
                if(new DAO().checkUsername(username).equals("used"))
                {
                    message+="Tên tài khoản này đã được sử dụng. Vui lòng chọn tên khác.</br>";
                }
                if(username.equals("")
                        ||request.getParameter("password").equals(""))
                {
                    message+="Những trường có dấu (*) bắt buộc phải nhập thông tin.</br>";
                }
                if(!password.equals(request.getParameter("repassword")))
                {
                    message+="Mật khẩu và mật khẩu nhập lại không trùng khớp.</br>";
                }
                request.setAttribute("message", message);
                request.setAttribute("name", name);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("repassword", repassword);
                request.setAttribute("address", address);
                request.setAttribute("phonenumber", phonenumber);
                request.setAttribute("creditcard", creditcard);
                request.setAttribute("email", email);
                RequestDispatcher dpc = request.getRequestDispatcher("register.jsp");
                dpc.forward(request, response);
            }
    }
}
