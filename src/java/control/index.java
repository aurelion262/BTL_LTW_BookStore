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
import model.Book;
import model.DAO;

/**
 *
 * @author i1vag_000
 */
@WebServlet(name="index", urlPatterns={"/index"})
public class index extends HttpServlet {

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
        DAO dao = new DAO();
        ArrayList<Book> saleOffList = dao.getSaleOffBook();
        ArrayList<Book> bestSellingList = dao.getBestSellingBook();
        request.setAttribute("saleOffList", saleOffList);
        request.setAttribute("bestSellingList", bestSellingList);
        dao.close();
        RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
        dpc.forward(request, response);
    }
}
