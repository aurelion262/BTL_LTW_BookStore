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
import model.Book;
import model.DAO;
import model.Log;

@WebServlet(name="editBookServlet", urlPatterns={"/editBookServlet"})
public class editBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Account sessionAccount = (Account)session.getAttribute("account");
        DAO dao = new DAO();
        String message="";
            if(sessionAccount.getRole().equals("ADMIN"))
            {
                String name = request.getParameter("name"),
                       author = request.getParameter("author"),
                       publisher = request.getParameter("publisher"),
                       category = request.getParameter("category"),
                       imageurl = request.getParameter("imageurl"),
                       description = request.getParameter("description");
                int    releasedYear = Integer.parseInt(request.getParameter("releasedYear")),
                       finalPrice = Integer.parseInt(request.getParameter("finalPrice")),
                       discount = Integer.parseInt(request.getParameter("discount"));
                int id = Integer.parseInt((String)request.getParameter("id"));
                Book b = new Book();
                b.setId(id);
                b.setName(name);
                b.setAuthor(author);
                b.setPublisher(publisher);
                b.setCategory(category);
                b.setImageurl(imageurl);
                b.setDescription(description);
                b.setReleasedyear(releasedYear);
                b.setFinalprice(finalPrice);
                b.setDiscount(discount);
                dao.editBook(b);
                
                String date = Calendar.getInstance().getTime().toString();
                String action = "EDIT";
                int accountId = sessionAccount.getId();
                Log l = new Log();
                l.setAccountId(accountId);
                l.setDate(date);
                l.setAction(action);
                l.setObjectId(id);
                l.setObjectType("BOOK");
                dao.addLog(l);
                
                message+="Cập nhật thành công </br>";
                request.setAttribute("message", message);
                RequestDispatcher dpc = request.getRequestDispatcher("bookDetailServlet?bookId="+id);
                dpc.forward(request, response);
            }
            else
            {
                response.sendRedirect("indexServlet");
            }
            dao.close();
    }
}
