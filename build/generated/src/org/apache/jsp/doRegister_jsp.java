package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.DAO;
import model.Account;

public final class doRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String message="";
            if(new DAO().checkUsername(request.getParameter("username")).equals("available")
                    &&!request.getParameter("username").equals("")
                    &&!request.getParameter("password").equals(""))
            {
                Account a = new Account();
                a.setUsername(request.getParameter("username"));
                a.setPassword(request.getParameter("password"));
                a.setRole("CLIENT");
                new DAO().addAccount(a);
                request.setAttribute("username", a.getUsername());
                RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
                dpc.forward(request, response);
            }
            else
            {
                if(new DAO().checkUsername(request.getParameter("username")).equals("used"))
                {
                    message+="Ten da duoc su dung. Vui long chon ten khac.\n";
                }
                if(request.getParameter("username").equals("")
                        ||request.getParameter("password").equals(""))
                {
                    message+="Nhung truong co dau (*) bat buoc phai nhap thong tin";
                }
                request.setAttribute("message", message);
                RequestDispatcher dpc = request.getRequestDispatcher("register.jsp");
                dpc.forward(request, response);
            }
        
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
