/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2022-04-22 01:58:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.resources.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.BibliotecaRest.objetos.Sessao;
import br.com.BibliotecaRest.objetos.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Página inicial</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"navbar/css/navbar.css\">\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"canvasjs.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/jquery-ui.css\">\r\n");
      out.write("<script src=\"relatorio/Chart.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/canvasjs.stock.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/canvas2image@1.0.5/canvas2image.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<script src=\"https://unpkg.com/jspdf@latest/dist/jspdf.umd.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"index.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"cruds.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-ui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"index.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/ajax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload = \"loadPage('main')\">\r\n");
      out.write("\r\n");
 


Sessao sessao = Sessao.getInstance();

Usuario usuario = sessao.getUsuario();

if(usuario == null){
response.sendRedirect("../../index.html");
}



      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"navbar-header\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t<li><a href=\"#\" onclick=\"loadPage('relatorio')\">Gráficos</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t<li><a href=\"#\" onclick=\"loadPage('autor')\">Registro de Serviços</a></li>\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul id=\"perfil\" class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> <span class=\"foto glyphicon glyphicon-user\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"loadPage('perfil')\">Perfil</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href = \"#\" onclick=\"deslogar()\">Sair</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"navbar-text nav navbar-right\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div id=\"registerContent\">\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
