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
 * @author ADMIN
 */
@WebServlet(name = "addAccountServlet", urlPatterns = {"/addAccountServlet"})
public class addAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            DAO dao = new DAO();
            String message="";
            String name = request.getParameter("name"),
                   username = request.getParameter("username"),
                   password = request.getParameter("password"),
                   repassword = request.getParameter("repassword"),
                   email = request.getParameter("email"),
                   address = request.getParameter("address"),
                   phonenumber = request.getParameter("phonenumber"),
                   role = request.getParameter("role");
            if(dao.checkUsername(username).equals("available")
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
                a.setEmail(email);
                a.setRole(role);
                dao.addStaff(a);
                message+="Cấp tài khoản mới thành công !";
                request.setAttribute("message", message);
                RequestDispatcher dpc = request.getRequestDispatcher("addAccount.jsp");
                dpc.forward(request, response);
            }
            else
            {
                if(dao.checkUsername(username).equals("used"))
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
                request.setAttribute("email", email);
                RequestDispatcher dpc = request.getRequestDispatcher("addAccount.jsp");
                dpc.forward(request, response);
            }
            dao.close();
    }
}
