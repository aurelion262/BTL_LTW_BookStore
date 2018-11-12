/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Book;
import model.DAO;
import model.Log;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="addBook", urlPatterns={"/addBook"})
public class addBook extends HttpServlet {

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
        DAO dao = new DAO();
        if(((Account)session.getAttribute("account")).getRole().equals("ADMIN")) // AUTHORIZE
        {
            Account sessionAccount = (Account)session.getAttribute("account");
            String message="";
    
            
            String name = request.getParameter("name"),
                   author = request.getParameter("author"),
                   publisher = request.getParameter("publisher"),
                   category = request.getParameter("category"),
                   imageurl = request.getParameter("imageurl"),
                   description = request.getParameter("description"),
                   releasedYear = request.getParameter("releasedYear"),
                   finalPrice = request.getParameter("finalPrice"),
                   discount = request.getParameter("discount");
            Book b = new Book();
            b.setAuthor(author);
            b.setCategory(category);
            b.setDescription(description);
            b.setDiscount(Integer.parseInt(discount));
            b.setFinalprice(Integer.parseInt(finalPrice));
            b.setImageurl(imageurl);
            b.setName(name);
            b.setPublisher(publisher);
            b.setReleasedyear(Integer.parseInt(releasedYear));
            dao.addBook(b);
            
            
            String date = Calendar.getInstance().getTime().toString();
            String action = "ADD";
            int accountId = sessionAccount.getId();
            Log l = new Log();
            l.setAccountId(accountId);
            l.setDate(date);
            l.setAction(action);
            l.setObjectId(dao.getLastBook().getId());
            l.setObjectType("BOOK");
            dao.addLog(l);
            
            message+="Thêm sách thành công !";
            request.setAttribute("message", message);
            RequestDispatcher dpc = request.getRequestDispatcher("addBook.jsp");
            dpc.forward(request, response);
        }
        else response.sendRedirect("index.jsp"); // AUTHORIZE
        dao.close();
    }
}
