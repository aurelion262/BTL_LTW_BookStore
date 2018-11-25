/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
 * @author Jichu
 */
@WebServlet(name = "forgetPasswordServlet", urlPatterns = {"/forgetPasswordServlet"})
public class forgetPasswordServlet extends HttpServlet {

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
        
        if((Account)session.getAttribute("account")==null)
        {
            String username = request.getParameter("username");
            if(dao.checkUsername(username).equals("used"))
            {
                String subject = "Forget Password - hieusachcu.com";
                Account a = dao.getAccount(username);
                String text = "The password of your account is : " + a.getPassword();
                String to = a.getEmail();


                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                Session mailSession = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("laptrinhwebnhom7", "matkhau1234");
                    }
                });
                try {
                    Message message = new MimeMessage(mailSession);
                    message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                    message.setFrom(new InternetAddress("laptrinhwebnhom7@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    message.setSubject(subject);
                    message.setText(text);
                    Transport.send(message);
                    request.setAttribute("reply", "Email chứa mật khẩu đã được gửi đi. Vui lòng kiểm tra email.");
                    RequestDispatcher dpc = request.getRequestDispatcher("forgetPassword.jsp");
                    dpc.forward(request, response);
                    response.sendRedirect("forgetPassword.jsp");
                } catch (MessagingException e) {
                }
            }
            else
            {
                request.setAttribute("reply", "Tên tài khoản bạn nhập không có trong hệ thống, vui lòng kiểm tra lại.");
                RequestDispatcher dpc = request.getRequestDispatcher("forgetPassword.jsp");
                dpc.forward(request, response);
            }            
        }
        else
        {
            response.sendRedirect("indexServlet");
        }
        dao.close();
}
}
