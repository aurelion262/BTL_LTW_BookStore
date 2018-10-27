package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Book;
import model.DAO;
import java.util.ArrayList;
import model.Account;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css_home.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>HOMEPAGE</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div id=\"logo\">\n");
      out.write("\t\t\t<a class=\"link\" href=\"index\">\n");
      out.write("\t\t\t<img id=\"image\" src=\"logo.png\">\n");
      out.write("\t\t\t</a>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"functionpart\">\n");
      out.write("\t\t\t<div id=\"inforpart\">\n");
      out.write("\t\t\t\t<div id=\"contactpart\">\n");
      out.write("\t\t\t\t\t<p id=\"email\">Email: hieusachcu@gmail.com</p>\n");
      out.write("\t\t\t\t\t<p id=\"sdt\">Contact: 0966017654</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"enterpagepart\">\n");
      out.write("\t\t\t\t\t");

                                            if(session.getAttribute("account")!=null)
                                            {
                                        
      out.write("\n");
      out.write("                                        Hello, ");
      out.print(((Account)session.getAttribute("account")).getUsername());
      out.write(" (<a class=\"link\" href=\"logout\">Đăng xuất</a>/<a class=\"link\" href=\"editAccount.jsp?id=");
      out.print(((Account)session.getAttribute("account")).getId());
      out.write("\">Chỉnh sửa hồ sơ</a>)\n");
      out.write("                                        ");

                                            }
                                            else{
                                        
      out.write("\n");
      out.write("                                            <br><a class=\"link\" href=\"register.jsp\">Đăng ký</a>/<a class=\"link\" href=\"login.jsp\">Đăng nhập</a>\n");
      out.write("                                        ");

                                            }
                                        
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("                                        ");

                                            if(session.getAttribute("account")!=null)
                                            {
                                                if(((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
                                                {
                                        
      out.write("\n");
      out.write("                                        <br><a class=\"link\" href=\"accountList\">Danh sách tài khoản</a> / <a class=\"link\" href=\"order.jsp\">Danh sách đơn hàng</a> / <a class=\"link\" href=\"log.jsp\">Nhật ký hoạt động</a> / <a class=\"link\" href=\"addBook.jsp\">Thêm sách</a>\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        <div id=\"searchbar\">\n");
      out.write("\t\t\t\t<div id=\"frames\">\n");
      out.write("\t\t\t\t<form method=\"POST\" action=\"searchBook\">\n");
      out.write("                                <select id=\"slctSearchOption\" name=\"searchOption\" onchange=\"jsSearchOption(this.options[this.selectedIndex].value)\">\n");
      out.write("                                    <option value=\"name\">Tên sách</option>\n");
      out.write("                                    <option value=\"author\">Tác giả</option>\n");
      out.write("                                    <option value=\"category\">Thể loại</option>\n");
      out.write("                                    <option value=\"finalPrice\">Giá</option>\n");
      out.write("                                </select>           \n");
      out.write("                                    <input type=\"text\" id=\"iptBookName\" name=\"bookName\" placeholder=\"Nhập tên\" value=''>\n");
      out.write("                                    <input type=\"number\" id=\"iptFloorPrice\" name=\"floorPrice\" placeholder=\"Min\" hidden=\"true\" value=''>\n");
      out.write("                                    <input type=\"number\" id=\"iptCeilingPrice\" name=\"ceilingPrice\" placeholder=\"Max\" hidden=\"true\" value=''>\n");
      out.write("                                    <input list=\"author\" name=\"author\" id=\"iptAuthor\" placeholder=\"Nhập tác giả\" hidden=\"true\" value=''>\n");
      out.write("                                    <datalist id=\"author\">\n");
      out.write("                                        ");

                                            ArrayList<String> authorList = new DAO().getAuthor();
                                            for(String s : authorList)
                                            {
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(s);
      out.write("\">\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </datalist>\n");
      out.write("                                    <input list=\"category\" name=\"category\" id=\"iptCategory\" placeholder=\"Nhập thể loại\" hidden=\"true\" value=''>\n");
      out.write("                                    <datalist id=\"category\">\n");
      out.write("                                        ");

                                            ArrayList<String> categoryList = new DAO().getCategory();
                                            for(String s : categoryList)
                                            {
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(s);
      out.write("\">\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </datalist>\n");
      out.write("                                    <input type=\"submit\" value=\"Tìm\">\n");
      out.write("                                </form>\n");
      out.write("                                </div>\n");
      out.write("                        </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"body\">\n");
      out.write("\t\t<div id=\"topbody\">\n");
      out.write("\t\t<div id=\"text2\">\n");
      out.write("                        ");

                            ArrayList<Book> saleOffList = (ArrayList<Book>)request.getAttribute("saleOffList");
                            if(saleOffList==null) response.sendRedirect("index");
                        
      out.write("\n");
      out.write("\t\t\t<a href=\"\" class=\"link\"><p id=\"discounttext\">Sale off Book</p></a>\n");
      out.write("\t\t\t<hr size=\"1\" color=\"black\">\n");
      out.write("\t\t</div>\n");
      out.write("                \n");
      out.write("\t\t<div id=\"discount\">\n");
      out.write("                    ");

                        try {

                    for(Book b : saleOffList)
                    {
                        
                    
      out.write("\n");
      out.write("\t\t\t<div class=\"abook\">\n");
      out.write("                            \n");
      out.write("\t\t\t\t<a class=\"link\" href=\"bookDetail?bookId=");
      out.print(b.getId());
      out.write("\"><image src=\"");
      out.print(b.getImageurl());
      out.write("\" class=\"book\"></image></a>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<p id=\"bookname\"><a class=\"link\" href=\"bookDetail?bookId=");
      out.print(b.getId());
      out.write('"');
      out.write('>');
      out.print(b.getName());
      out.write("</a></p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<p id=\"newprice\">");
      out.print(b.getFinalprice());
      out.write("<span>VND</span> </p>\n");
      out.write("\t\t\t\t<p id=\"oldprice\">");
      out.print((b.getFinalprice()+b.getDiscount()));
      out.write("<span>VND</span> </p>\n");
      out.write("                                <a href=\"addToCart\"><img src=\"icon/cart.png\" width=\"35px\" height=\"35px\">Add to cart</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("                    ");

                    }
                                                  
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"botbody\">\n");
      out.write("\t\t<div id=\"bestsalling\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"text1\">\n");
      out.write("\t\t\t\t<a href=\"\" class=\"link\" ><p id=\"bestsallingtext\">Best Salling Book</p></a>\n");
      out.write("\t\t\t\t<hr size=\"1\" color=\"black\">\n");
      out.write("\t\t\t</div>\n");
      out.write("                        ");

                            ArrayList<Book> bestSellingList = (ArrayList<Book>)request.getAttribute("bestSellingList");
                        
      out.write("\n");
      out.write("\t\t\t");

                            try {
                                    
                              
                            for(Book b : bestSellingList)
                            {
                                
                        
      out.write("\n");
      out.write("\t\t\t<div class=\"abook\">\n");
      out.write("                            \n");
      out.write("\t\t\t\t<a class=\"link\" href=\"bookDetail?bookId=");
      out.print(b.getId());
      out.write("\"><image src=\"");
      out.print(b.getImageurl());
      out.write("\" class=\"book\"></image></a>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<p id=\"bookname\"><a class=\"link\" href=\"bookDetail?bookId=");
      out.print(b.getId());
      out.write('"');
      out.write('>');
      out.print(b.getName());
      out.write("</a></p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<p id=\"newprice\">");
      out.print(b.getFinalprice());
      out.write("<span>VND</span> </p>\n");
      out.write("\t\t\t\t<p id=\"oldprice\">");
      out.print((b.getFinalprice()+b.getDiscount()));
      out.write("<span>VND</span> </p>\n");
      out.write("                                <a href=\"addToCart\"><img src=\"icon/cart.png\" width=\"35px\" height=\"35px\">Add to cart</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        ");

                            
                            }
                            } catch (Exception e) {
                                e.printStackTrace();
                                }
                        
      out.write("\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"footer\">\n");
      out.write("\t\t<div id=\"address\">\n");
      out.write("\t\t\t<p class=\"text3\">Address</p>\n");
      out.write("\t\t\t<p class=\"text4\">Km10 Nguyen Trai, Ha Dong dist, Ha Noi city</p>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"slogan\">\n");
      out.write("\t\t\t<p class=\"text3\">Slogan</p>\n");
      out.write("\t\t\t<p class=\"text4\">Khong thieu sach nao ban can.</p>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"payment\">\n");
      out.write("\t\t\t<p class=\"text3\">Payment</p>\n");
      out.write("\t\t\t<img src=\"method.PNG\" id=\"payimage\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("        ");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
