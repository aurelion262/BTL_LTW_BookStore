package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.DAO;
import model.Account;
import java.util.ArrayList;
import model.DAO;
import model.Account;

public final class addBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"register.css\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Thêm Sách</title>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"header.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>HOMEPAGE</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js.js\"></script>\n");
      out.write("    </head>\n");
      out.write("        ");

            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
//            Account sessionAccount = (Account)session.getAttribute("account");  
            DAO headerDAO = new DAO();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div id=\"logo\">\n");
      out.write("\t\t\t<a class=\"link\" href=\"index\">\n");
      out.write("\t\t\t<img id=\"image\" src=\"logo.png\">\n");
      out.write("\t\t\t</a>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"functionpart\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div id=\"contactpart\">\n");
      out.write("\t\t\t\t\t<p id=\"email\">Email: hieusachcu@gmail.com</p>\n");
      out.write("                                        <p id=\"sdt\">Contact: 0966017654 / <a class=\"link\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\" href=\"feedBack.jsp\">Góp ý</a></p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("        ");
      out.write("\n");
      out.write("                        <div id=\"inforpart\">\n");
      out.write("\t\t\t\t<div id=\"enterpagepart\">\n");
      out.write("\t\t\t\t\t");

                                            if(session.getAttribute("account")!=null)
                                            {
                                        
      out.write("\n");
      out.write("                                        Hello, <a class=\"link\" href=\"editAccount.jsp?id=");
      out.print(((Account)session.getAttribute("account")).getId());
      out.write('"');
      out.write('>');
      out.print(((Account)session.getAttribute("account")).getUsername());
      out.write("</a> (<a class=\"link\" href=\"logout\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Đăng xuất</a>/<a class=\"link\" href=\"cart\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Giỏ hàng</a>/<a class=\"link\" href=\"orderHistory\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Tình trạng đơn hàng</a>/<a class=\"link\" href=\"favoriteList\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Yêu thích</a>)\n");
      out.write("                                        ");

                                            }
                                            else{
                                        
      out.write("\n");
      out.write("                                            <br><a class=\"link\" href=\"register.jsp\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Đăng ký</a>/<a class=\"link\" href=\"login.jsp\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Đăng nhập</a>\n");
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
      out.write("                                        <br><a class=\"link\" href=\"accountList\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Danh sách tài khoản</a> / <a class=\"link\" href=\"orderList\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Danh sách đơn hàng</a> / <a class=\"link\" href=\"viewLog\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Nhật ký hoạt động</a> / <a class=\"link\" href=\"addBook.jsp\" onmouseover=\"this.setAttribute('style','text-decoration:underline')\" onmouseout=\"this.setAttribute('style','text-decoration:none')\">Thêm sách</a>\n");
      out.write("                                        ");

                                                }
                                            }
                                        
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        <div id=\"searchbar\">\n");
      out.write("\t\t\t\t<div id=\"frames\">\n");
      out.write("\t\t\t\t<form method=\"POST\" action=\"searchBook\">\n");
      out.write("                                <select style=\"font-family: comic sans ms\" id=\"slctSearchOption\" name=\"searchOption\" onchange=\"jsSearchOption(this.options[this.selectedIndex].value)\">\n");
      out.write("                                    <option style=\"font-family: comic sans ms\" value=\"name\">Tên sách</option>\n");
      out.write("                                    <option style=\"font-family: comic sans ms\" value=\"author\">Tác giả</option>\n");
      out.write("                                    <option style=\"font-family: comic sans ms\" value=\"category\">Thể loại</option>\n");
      out.write("                                    <option style=\"font-family: comic sans ms\" value=\"finalPrice\">Giá</option>\n");
      out.write("                                </select>           \n");
      out.write("                                    <input style=\"font-family: comic sans ms\" type=\"text\" id=\"iptBookName\" name=\"bookName\" placeholder=\"Nhập tên\" value=''>\n");
      out.write("                                    <input style=\"font-family: comic sans ms\" type=\"number\" id=\"iptFloorPrice\" name=\"floorPrice\" placeholder=\"Min\" hidden=\"true\" value=''>\n");
      out.write("                                    <input style=\"font-family: comic sans ms\" type=\"number\" id=\"iptCeilingPrice\" name=\"ceilingPrice\" placeholder=\"Max\" hidden=\"true\" value=''>\n");
      out.write("                                    <input style=\"font-family: comic sans ms\" list=\"author\" name=\"author\" id=\"iptAuthor\" placeholder=\"Nhập tác giả\" hidden=\"true\" value=''>\n");
      out.write("                                    <datalist id=\"author\">\n");
      out.write("                                        ");

                                            ArrayList<String> authorList = headerDAO.getAuthor();
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
      out.write("                                    <input style=\"font-family: comic sans ms\" list=\"category\" name=\"category\" id=\"iptCategory\" placeholder=\"Nhập thể loại\" hidden=\"true\" value=''>\n");
      out.write("                                    <datalist id=\"category\">\n");
      out.write("                                        ");

                                            ArrayList<String> categoryList = headerDAO.getCategory();
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
      out.write("                                    <input style=\"font-family: comic sans ms\" type=\"submit\" value=\"Tìm\">\n");
      out.write("                                </form>\n");
      out.write("                                </div>\n");
      out.write("                        </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
headerDAO.close();
      out.write('\n');
      out.write("\r\n");
      out.write("        ");

            if(((Account)(session.getAttribute("account")))!=null&&((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
            {
        
      out.write("\r\n");
      out.write("        <form method=\"POST\" action=\"addBookServlet\">\r\n");
      out.write("        <div id=\"outsite\">\r\n");
      out.write("        <div id=\"cover\">\r\n");
      out.write("            <div id=\"registertext\" class=\"centerHor\">\r\n");
      out.write("                <div id=\"textre\">Thêm sách</div>\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t<div>Tên sách</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"name\" class=\"inputtext\" placeholder=\"Tên sách\">\r\n");
      out.write("\t\t<div>Tác giả</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"author\" class=\"inputtext\" placeholder=\"Tác giả\">\r\n");
      out.write("\t\t<div>Thể loại</div>\r\n");
      out.write("\t\t<input list=\"category\" name=\"category\" id=\"iptCategory\" class=\"inputtext\" placeholder=\"Thể loại\">\r\n");
      out.write("                <datalist id=\"category\">\r\n");
      out.write("                    ");

                        for(String s : categoryList)
                        {
                    
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(s);
      out.write("\">\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </datalist>\r\n");
      out.write("\t\t<div>Nhà xuất bản</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"publisher\" class=\"inputtext\" placeholder=\"Nhà xuất bản\">\r\n");
      out.write("                <div>Mô tả</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"description\" class=\"inputtext\" placeholder=\"Mô tả\">\r\n");
      out.write("                <div>Năm xuất bản</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"releasedYear\" class=\"inputtext\" placeholder=\"Năm xuất bản\">\r\n");
      out.write("                <div>URL ảnh</div>\r\n");
      out.write("                <input id=\"iptImage\" type=\"file\" accept=\"image/*\" class=\"inputtext\" placeholder=\"URL ảnh\" onchange=\"jsUpdateImage(event,'showImage');jsSetAttribute('iptImageURL','value',jsImageURL1);document.getElementById('iptImageURL').value='image/'+jsImageURL;\">\r\n");
      out.write("                <div><img width=\"400\" height=\"250\" id=\"showImage\" hidden=\"true\" ></div>\r\n");
      out.write("                <input type='text' id=\"iptImageURL\" name=\"imageurl\" class=\"inputtext\" hidden='true'>\r\n");
      out.write("                <div>Giá cuối(VND)</div>\r\n");
      out.write("\t\t<input id=\"asd\" type=\"text\" name=\"finalPrice\" class=\"inputtext\" placeholder=\"Giá cuối\">\r\n");
      out.write("                <div>Chiếu khấu (VND)</div>\r\n");
      out.write("\t\t<input type=\"text\" name=\"discount\" class=\"inputtext\" placeholder=\"Giảm giá\">\r\n");
      out.write("\t\t<div style=\"padding: 14px\" class=\"centerHor\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Thêm sách\" ></input>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
 
            String message = (String)request.getAttribute("message");
            if(message!=null){ 
      out.write("\r\n");
      out.write("                <p>");
      out.print(message);
      out.write("</p>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        ");
}
        else
        {
            response.sendRedirect("index.jsp");
        }
      out.write("\r\n");
      out.write("        ");
      out.write("<head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"footer.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>HOMEPAGE</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("        \t<div id=\"footer\">\n");
      out.write("\t\t<div id=\"address\">\n");
      out.write("\t\t\t<p class=\"text3\">Address</p>\n");
      out.write("\t\t\t<p class=\"text4\">Cs1:Km10 Nguyen Trai, Ha Dong dist, Ha Noi city</p>\n");
      out.write("\t\t\t<p class=\"text4\">Cs2:152 Nguyen Khuyen, 1st dist, Ho Chi Minh city</p>\n");
      out.write("\t\t\t<p class=\"text4\">Cs3:45 Le Loi, Hoan Kiem dist, Ha Noi city</p>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"slogan\">\n");
      out.write("\t\t\t<p class=\"text3\">Slogan</p>\n");
      out.write("\t\t\t<p class=\"text4\">Whenever you wanna find a book </p>\n");
      out.write("\t\t\t<p class=\"text4\">Let us help you find it!</p>\n");
      out.write("\t\t\t<div id=\"soci\">\n");
      out.write("\t\t\t<a href=\"https://www.facebook.com/\" > <img src=\"icon/fb.png\"> </a>\n");
      out.write("\t\t\t<a href=\"https://www.instagram.com/\"> <img src=\"icon/ig.png\"></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"payment\">\n");
      out.write("\t\t\t<p class=\"text3\">Payment</p>\n");
      out.write("\t\t\t<img src=\"method.PNG\" id=\"payimage\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div> \n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
