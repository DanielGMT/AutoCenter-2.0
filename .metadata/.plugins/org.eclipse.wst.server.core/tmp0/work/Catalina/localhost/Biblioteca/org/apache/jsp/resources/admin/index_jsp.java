/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2022-04-25 08:45:22 UTC
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
      out.write("<title>Magalhães Auto Center</title>\r\n");
      out.write("<!-- meta description -->\r\n");
      out.write("        <meta name=\"description\" content=\"\">      \r\n");
      out.write("        <!-- mobile viwport meta -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <!-- fevicon -->\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"favicon.ico\">\r\n");
      out.write("        \r\n");
      out.write("        <!-- ================================\r\n");
      out.write("        CSS Files\r\n");
      out.write("        ================================= -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Libre+Baskerville:400,400i|Open+Sans:400,600,700,800\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../phantom/light/css/themefisher-fonts.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../phantom/light/css/owl.carousel.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../phantom/light/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../phantom/light/css/main.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../phantom/light/css/dark.css\">\r\n");
      out.write("        <link id=\"color-changer\" rel=\"stylesheet\" href=\"../../phantom/light/css/colors/red.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery-ui.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"navbar/css/navbar.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"index.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"cruds.css\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <script src=\"../../phantom/light/js/vendor/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- <script src=\"../../phantom/light/js/jquery.easing.min.js\"></script> -->\r\n");
      out.write("        <script src=\"../../phantom/light/js/isotope.pkgd.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/jquery-validation.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/form.min.js\"></script>\r\n");
      out.write("        <script src=\"../../phantom/light/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"canvasjs.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"relatorio/Chart.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-3.3.1.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-ui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"index.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/ajax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write(" <body class=\"light\">\r\n");
      out.write("\r\n");
 


Sessao sessao = Sessao.getInstance();

Usuario usuario = sessao.getUsuario();

if(usuario == null){
response.sendRedirect("../../index.html");
}



      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"registerContent\">\r\n");
      out.write("\t\t \r\n");
      out.write("      \r\n");
      out.write("\t  <main class=\"site-wrapper\">\r\n");
      out.write("            <div class=\"pt-table\">\r\n");
      out.write("                <div class=\"pt-tablecell page-home relative\" style=\"background-image: url('../../phantom/light/img/banner.jpg');\">\r\n");
      out.write("                    <div class=\"overlay\"></div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-xs-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8\">\r\n");
      out.write("                                <div class=\"page-title home text-center\">\r\n");
      out.write("                                    <h1>Magalhães Auto Center</h1>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"hexagon-menu clear\">\r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" onclick=\"loadPage('main')\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-ion-ios-home\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">Início</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-profile-male\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">#</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" onclick=\"loadPage('autor')\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-tools-2\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">Serviços</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>    \r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" onclick=\"loadPage('relatorio')\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-bargraph\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">Relatório</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-briefcase2\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">#</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                  \r\n");
      out.write("                                    <div class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <a href=\"#\" class=\"hex-content\">\r\n");
      out.write("                                            <span class=\"hex-content-inner\">\r\n");
      out.write("                                                <span class=\"icon\">\r\n");
      out.write("                                                    <i class=\"tf-envelope2\"></i>\r\n");
      out.write("                                                </span>\r\n");
      out.write("                                                <span class=\"title\">#</span>\r\n");
      out.write("                                            </span>\r\n");
      out.write("                                            <svg viewbox=\"0 0 173.20508075688772 200\" height=\"200\" width=\"174\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z\" fill=\"#1e2530\"></path></svg>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div> <!-- /.hexagon-menu -->\r\n");
      out.write("\r\n");
      out.write("                            </div> <!-- /.col-xs-12 -->\r\n");
      out.write("\r\n");
      out.write("                        </div> <!-- /.row -->\r\n");
      out.write("                    </div> <!-- /.container -->\r\n");
      out.write("\r\n");
      out.write("                </div> <!-- /.pt-tablecell -->\r\n");
      out.write("            </div> <!-- /.pt-table -->\r\n");
      out.write("        </main> <!-- /.site-wrapper -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("    </body>\r\n");
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
