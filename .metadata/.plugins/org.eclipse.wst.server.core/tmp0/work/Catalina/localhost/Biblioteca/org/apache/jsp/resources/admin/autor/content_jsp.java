/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2022-04-25 09:32:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.resources.admin.autor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<script type=\"text/javascript\" src=\"autor/js/autor.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"imprimir/imprimir.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"src=\"autor/js/jquery.maskMoney.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"src=\"autor/js/jquery.mask.js\"></script>\r\n");
      out.write("\r\n");
      out.write(" <div  class=\"hexagon-menu clear\">\r\n");
      out.write("                                    <div  class=\"hexagon-item\">\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            \r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"hex-item\">\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                            <div></div>\r\n");
      out.write("                                        \r\n");
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
      out.write("                                    \r\n");
      out.write("                                </div> <!-- /.hexagon-menu -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"cadastrarAutor\">\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<button class=\"btn btn-primary\" onclick=\"SENAI.biblioteca.descerPag()\" id=\"downButton\" type=\"button\"\r\n");
      out.write("\t\t\tdata-toggle=\"collapse\" data-target=\"#collapseExample\"\r\n");
      out.write("\t\t\taria-expanded=\"false\" aria-controls=\"collapseExample\">\r\n");
      out.write("\t\t\tCadastrar Novo Serviço <span class=\"caret\"></span>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<div class=\"collapse\" id=\"collapseExample\">\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"servico\">Serviço</label>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t <div id=\"lugarzinho\">\r\n");
      out.write("\t\t\t <div>\r\n");
      out.write("\t\t\t \tItem1<div><select id='servico0'><option value='Outro'>Outro</option><option value='Amortecedor dianteiro'>Amortecedor dianteiro</option><option value='Amortecedor trazeiro'>Amortecedor trazeiro</option><option value='Balanceamento'>Balanceamento</option><option value='Bico'>Bico</option><option value='Batente'>Batente</option><option value='Balança'>Balança</option><option value='Barra axial'>Barra axial</option><option value='Bieleta'>Bieleta</option><option value='Bucha da balança'>Bucha da balança</option><option value='Bucha da barra estabilizadora'>Bucha da barra estabilizadora</option><option value='Coifa do amortecedor'>Coifa do amortecedor</option><option value='Coifa da homocinética'>Coifa da homocinética</option><option value='Camara de Moto'>Camara de Moto</option><option value='Camara de Carro'>Camara de Carro</option><option value='Coxim'>Coxim</option><option value='Coxim de câmbio'>Coxim de câmbio</option><option value='Conserto de roda'>Conserto de roda</option><option value='Cubo dianteiro'>Cubo dianteiro</option><option value='Cubo trazeiro'>Cubo trazeiro</option><option value='Cilindro de freio'>Cilindro de freio</option><option value='Desempeno de Roda'>Desempeno de Roda</option><option value='Disco de freio dianteiro'>Disco de freio dianteiro</option><option value='Disco de freio trazeiro'>Disco de freio trazeiro</option><option value='Friso de pneu'>Friso de pneu</option><option value='Homocinética'>Homocinética</option><option value='Manutenção'>Manutenção</option><option value='Mão de obra'>Mão de obra</option><option value='Montagem'>Montagem</option><option value='Moto'>Moto</option><option value='Mola'>Mola</option><option value='Morceguinho'>Morceguinho</option><option value='Pastilha de freio dianteiro'>Pastilha de freio dianteiro</option><option value='Pastilha de freio trazeiro'>Pastilha de freio trazeiro</option><option value='Pneu 13'>Pneu 13</option><option value='Pneu 14'>Pneu 14</option><option value='Pneu 15'>Pneu 15</option><option value='Pneu 16'>Pneu 16</option><option value='Pneu 17'>Pneu 17</option><option value='Pneu 18'>Pneu 18</option><option value='Pneu 19'>Pneu 19</option><option value='Pneu 20'>Pneu 20</option><option value='Pneu 21'>Pneu 21</option><option value='Pivô'>Pivô</option><option value='Refil'>Refil</option><option value='Remendo frio'>Remendo frio</option><option value='Remendo quente'>Remendo quente</option><option value='Remendo de Camara'>Remendo de Camara</option><option value='Rebaixamento'>Rebaixamento</option><option value='Roda'>Roda</option><option value='Rodízio'>Rodízio</option><option value='Rolamento dianteiro'>Rolamento dianteiro</option><option value='Rolamento trazeiro'>Rolamento trazeiro</option><option value='Socorro'>Socorro</option><option value='Troca'>Troca</option><option value='Troca de bico'>Troca de bico</option><option value='Troca de calota'>Troca de calota</option><option value='Terminal de direção'>Terminal de direção</option><option value='Venda de pneu 13'>Venda de pneu 13</option><option value='Venda de pneu 14'>Venda de pneu 14</option><option value='Venda de pneu 15'>Venda de pneu 15</option><option value='Venda de pneu 16'>Venda de pneu 16</option><option value='Venda de pneu 17'>Venda de pneu 17</option><option value='Venda de pneu 18'>Venda de pneu 18</option><option value='Venda de pneu 19'>Venda de pneu 19</option><option value='Venda de pneu 20'>Venda de pneu 20</option><option value='Venda de roda'>Venda de roda</option><option value='Venda de Acessório'>Venda de Acessório</option><option value='Vulcanizo'>Vulcanizo</option><option value='Vedação'>Vedação</option></select>\r\n");
      out.write("\t\t\t\t<select onChange='SENAI.biblioteca.selectQnt(this)' name='quantidade' id='quantidade0'><option value='1'>x1</option><option value='2'>x2</option><option value='3'>x3</option><option value='4'>x4</option><option value='5'>x5</option><option value='6'>x6</option><option value='7'>x7</option><option value='8'>x8</option><option value='9'>x9</option><option value='10'>x10</option></select><input class='form-control' id='item0' onblur= 'SENAI.biblioteca.blur(this)' autocomplete='off' placeholder='Valor Unitário'><label class='control-label'></label></div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t\t \t<a class = \"edit\" onclick = \"SENAI.biblioteca.acrescentarServico()\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<i class=\"glyphicon glyphicon-plus\" style=\"color: blue;\"></i></a>\r\n");
      out.write("\t\t\t \t<a class = \"edit\" onclick = \"SENAI.biblioteca.tirarServico()\">\r\n");
      out.write("\t\t\t \t\r\n");
      out.write("\t\t\t\t<i class=\"glyphicon glyphicon-minus\" style=\"color: red;\"></i></a>\r\n");
      out.write("\t\t\t\t<BR><BR>\r\n");
      out.write("\t\t\t\t<div style=\"width: 50%; float: left;\">\r\n");
      out.write("\t\t\t\t\t<label for=\"valor\">Valor Total</label><input disabled\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" style=\"background-color: #b1dd9e;\" onblur=\"SENAI.biblioteca.teste(this)\" value =\"R$\" autocomplete=\"off\" type=\"text\" id=\"inputvalor\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"width: 50%; float: right;\">\r\n");
      out.write("\t\t\t\t\t<label for=\"data\">Data de serviço</label> <input\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" autocomplete=\"off\" type=\"date\" id=\"inputdata\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"width: 50%; float: left;\">\r\n");
      out.write("\t\t\t\t\t<label for=\"valor\">Desconto: </label>\r\n");
      out.write("\t\t\t\t\t<input style=\"background-color: #cd5c5c;\" onblur=\"SENAI.biblioteca.outroblur(this)\" placeholder=\"- R$\" autocomplete=\"off\" type=\"text\" id=\"inputvalordesc\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"width: 50%; float: left;\">\r\n");
      out.write("\t\t\t\t\t<label class = \"control-label\" for=\"observacao\">Observação</label>\r\n");
      out.write("\t\t\t\t\t<textarea class='form-control' id='inputobservacao' cols='20' autocomplete='off' placeholder='Não obrigatório'></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"width: 50%; float: left;\">\r\n");
      out.write("\t\t\t\t\t<label class=\"control-label\" for=\"marca\">Marca</label>\r\n");
      out.write("\t\t\t\t<select class=\"form-control\" name=\"marca\" id=\"inputmarca\">\r\n");
      out.write("\t\t\t\t<option value=\"Outro\">Outro</option>\r\n");
      out.write("\t\t\t\t<option value=\"Abarth\">Abarth</option>\r\n");
      out.write("\t\t\t\t<option value=\"Alfa Romeo\">Alfa Romeo</option>\r\n");
      out.write("\t\t\t\t<option value=\"Alpine\">Alpine</option>\r\n");
      out.write("\t\t\t\t<option value=\"Aston Martin\">Aston Martin</option>\r\n");
      out.write("\t\t\t\t<option value=\"Audi\">Audi</option>\r\n");
      out.write("\t\t\t\t<option value=\"Bentley\">Bentley</option>\r\n");
      out.write("\t\t\t\t<option value=\"BMW\">BMW</option>\r\n");
      out.write("\t\t\t\t<option value=\"Citroën\">Citroën</option>\r\n");
      out.write("\t\t\t\t<option value=\"Chevrolet\">Chevrolet</option>\r\n");
      out.write("\t\t\t\t<option value=\"Cupra\">Cupra</option>\r\n");
      out.write("\t\t\t\t<option value=\"Dacia\">Dacia</option>\r\n");
      out.write("\t\t\t\t<option value=\"DS\">DS</option>\r\n");
      out.write("\t\t\t\t<option value=\"Ferrari\">Ferrari</option>\r\n");
      out.write("\t\t\t\t<option value=\"Fiat\">Fiat</option>\r\n");
      out.write("\t\t\t\t<option value=\"Ford\">Ford</option>\r\n");
      out.write("\t\t\t\t<option value=\"Hafei\">Hafei</option>\r\n");
      out.write("\t\t\t\t<option value=\"Honda\">Honda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Hyundai\">Hyundai</option>\r\n");
      out.write("\t\t\t\t<option value=\"Jaguar\">Jaguar</option>\r\n");
      out.write("\t\t\t\t<option value=\"JEEP\">JEEP</option>\r\n");
      out.write("\t\t\t\t<option value=\"KIA\">KIA</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lamborghini\">Lamborghini</option>\r\n");
      out.write("\t\t\t\t<option value=\"Land Rover\">Land Rover</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lexus\">Lexus</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lifan\">Lifan</option>\r\n");
      out.write("\t\t\t\t<option value=\"Maserati\">Maserati</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mazda\">Mazda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mercedes-Benz\">Mercedes-Benz</option>\r\n");
      out.write("\t\t\t\t<option value=\"MG\">MG</option>\r\n");
      out.write("\t\t\t\t<option value=\"MINI\">MINI</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mitsubishi\">Mitsubishi</option>\r\n");
      out.write("\t\t\t\t<option value=\"Nissan\">Nissan</option>\r\n");
      out.write("\t\t\t\t<option value=\"Opel\">Opel</option>\r\n");
      out.write("\t\t\t\t<option value=\"Peugeot\">Peugeot</option>\r\n");
      out.write("\t\t\t\t<option value=\"Porsche\">Porsche</option>\r\n");
      out.write("\t\t\t\t<option value=\"Renault\">Renault</option>\r\n");
      out.write("\t\t\t\t<option value=\"SEAT\">SEAT</option>\r\n");
      out.write("\t\t\t\t<option value=\"Skoda\">Skoda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Smart\">Smart</option>\r\n");
      out.write("\t\t\t\t<option value=\"Suzuki\">Suzuki</option>\t\r\n");
      out.write("\t\t\t\t<option value=\"Subaru\">Subaru</option>\r\n");
      out.write("\t\t\t\t<option value=\"TESLA\">TESLA</option>\r\n");
      out.write("\t\t\t\t<option value=\"Toyota\">Toyota</option>\r\n");
      out.write("\t\t\t\t<option value=\"Volkswagen\">Volkswagen</option>\r\n");
      out.write("\t\t\t\t<option value=\"Volvo\">Volvo</option>\r\n");
      out.write("\t\t\t</select></div><div style=\"width: 50%; float: right;\">\r\n");
      out.write("\t\t\t<label for=\"modelo\">Modelo</label> <input class=\"form-control\" autocomplete=\"on\" placeholder=\"Não obrigatório\" id=\"inputmodelo\">\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"width: 50%; float: left;\">\r\n");
      out.write("\t\t<label for=\"placa\">Placa</label> <input\r\n");
      out.write("\t\tname=\"placas\" class=\"form-control\" placeholder=\"Não obrigatório\" autocomplete=\"off\" type=\"text\" id=\"inputplaca\">\r\n");
      out.write("\t</div>\t\t\r\n");
      out.write("\t<div style=\"width: 50%; float: right;\">\r\n");
      out.write("\t<label for=\"metodo\">Método de pagamento *</label>\r\n");
      out.write("\t\t\t\t<select class=\"form-control\" name=\"metodo\" id=\"inputmetodo\">\r\n");
      out.write("\t\t\t\t\t<option value=1>Dinheiro</option>\r\n");
      out.write("\t\t\t\t\t<option value=2>Cartão Débito</option>\r\n");
      out.write("\t\t\t\t\t<option value=3>Cartão Crédito</option>\r\n");
      out.write("\t\t\t\t\t<option value=4>PIX</option>\r\n");
      out.write("\t\t\t\t</select>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"entrar\" style=\"margin-left: 40%;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<button type=\"button\" id=\"add-new\"\r\n");
      out.write("\t\t\t\tonclick=\"SENAI.biblioteca.cadastrarServico()\" class=\"btn btn-primary\">Registrar</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"table-wrapper\">\r\n");
      out.write("\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t<h2 class=\"pt-3 pb-4 text-center font-bold font-up deep-purple-text\">Serviços\r\n");
      out.write("\t\t\tRegistrados</h2>\r\n");
      out.write("\t\t<div id=\"teste\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"date\" onChange=\"SENAI.biblioteca.buscarServ()\" id=\"searchDate\" /><input type=\"date\" onChange=\"SENAI.biblioteca.buscarServ()\" id=\"searchDate2\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<select class=\"form-control\" id=\"selectFiltro\" onChange=\"SENAI.biblioteca.verificaResult(this)\"><option style=\"display:none;\" disabled value='50'>Filtrar</option><option style=\"background-color: #003d80; color: #d1d1d1;\" value='0'>Total</option><option style=\"background-color: #003d80; color: #d1d1d1;\" value='1'>Total de Hoje</option><option style=\"background-color: #1167b1; color: white;\" value='3'>Hoje em Dinheiro</option><option style=\"background-color: #1167b1; color: white;\" value='4'>Hoje em Débito</option><option style=\"background-color: #1167b1; color: white;\"  value='5'>Hoje em Crédito</option><option style=\"background-color: #1167b1; color: white;\" value='6'>Hoje em Pix</option><option style=\"background-color: #2a9df4;\" value='2'>Últimos 30 Dias</option><option style=\"background-color: #2a9df4;\" value='7'>Últimos 30 Dias em Dinheiro</option><option style=\"background-color: #2a9df4;\" value='8'>Últimos 30 Dias em Débito</option><option style=\"background-color: #2a9df4;\" value='9'>Últimos 30 Dias em Crédito</option><option style=\"background-color: #2a9df4;\" value='10'>Últimos 30 Dias em PIX</option></select>\r\n");
      out.write("\t\t\t<input type=\"hidden\" class=\"form-control\" onChange=\"SENAI.biblioteca.buscarServico()\" id=\"searchBar\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div><label for=\"totalglobal\">Total Líquido: <br></label><input id=\"totalglobal\" disabled name=\"totalglobal\" type=\"text\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"resultadoServicos\"></div>\r\n");
      out.write("<ul class=\"pagination\">\r\n");
      out.write("    <li class=\"page-item\">\r\n");
      out.write("      <a class=\"first\" href=\"#\"><<</a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"page-item\">\r\n");
      out.write("      <a class=\"prev\" href=\"#\"><</a>\r\n");
      out.write("    </li>\r\n");
      out.write("   <li class=\"numbers\">\r\n");
      out.write("   \r\n");
      out.write("   </li>\r\n");
      out.write("    <li class=\"page-item\">\r\n");
      out.write("      <a class=\"next\" href=\"#\">></a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li class=\"page-item\">\r\n");
      out.write("      <a class=\"last\" href=\"#\">>></a>\r\n");
      out.write("    </li>\r\n");
      out.write("  </ul>\r\n");
      out.write("\t<div class=\"clearfix\">\r\n");
      out.write("\t\t<div class=\"hint-text\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"editarServico\" style=\"display: none\">\r\n");
      out.write("\t<label>Serviço:</label> <textarea disabled id=\"servicoEdit\" class=\"form-control\" name=\"servico\" type=\"text\"></textarea>\r\n");
      out.write("\t<input name=\"idServico\" id=\"idServicoEdit\" type=\"hidden\">\r\n");
      out.write("\t<label>Observação:</label>\r\n");
      out.write("\t<textarea disabled class=\"form-control\" id=\"observacaoEdit\" cols=\"20\" autocomplete=\"off\"></textarea>\r\n");
      out.write("\t<input name=\"idObservacao\" id=\"idOservacaoEdit\" type=\"hidden\">\r\n");
      out.write("\t<label>Marca:</label> <select disabled class=\"form-control\" name=\"marca\" id=\"marcaEdit\">\r\n");
      out.write("\t\t\t\t<option value=\"Outro\">Outro</option>\r\n");
      out.write("\t\t\t\t<option value=\"Abarth\">Abarth</option>\r\n");
      out.write("\t\t\t\t<option value=\"Alfa Romeo\">Alfa Romeo</option>\r\n");
      out.write("\t\t\t\t<option value=\"Alpine\">Alpine</option>\r\n");
      out.write("\t\t\t\t<option value=\"Aston Martin\">Aston Martin</option>\r\n");
      out.write("\t\t\t\t<option value=\"Audi\">Audi</option>\r\n");
      out.write("\t\t\t\t<option value=\"Bentley\">Bentley</option>\r\n");
      out.write("\t\t\t\t<option value=\"BMW\">BMW</option>\r\n");
      out.write("\t\t\t\t<option value=\"Citroën\">Citroën</option>\r\n");
      out.write("\t\t\t\t<option value=\"Chevrolet\">Chevrolet</option>\r\n");
      out.write("\t\t\t\t<option value=\"Cupra\">Cupra</option>\r\n");
      out.write("\t\t\t\t<option value=\"Dacia\">Dacia</option>\r\n");
      out.write("\t\t\t\t<option value=\"DS\">DS</option>\r\n");
      out.write("\t\t\t\t<option value=\"Ferrari\">Ferrari</option>\r\n");
      out.write("\t\t\t\t<option value=\"Fiat\">Fiat</option>\r\n");
      out.write("\t\t\t\t<option value=\"Ford\">Ford</option>\r\n");
      out.write("\t\t\t\t<option value=\"Hafei\">Hafei</option>\r\n");
      out.write("\t\t\t\t<option value=\"Honda\">Honda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Hyundai\">Hyundai</option>\r\n");
      out.write("\t\t\t\t<option value=\"Jaguar\">Jaguar</option>\r\n");
      out.write("\t\t\t\t<option value=\"JEEP\">JEEP</option>\r\n");
      out.write("\t\t\t\t<option value=\"KIA\">KIA</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lamborghini\">Lamborghini</option>\r\n");
      out.write("\t\t\t\t<option value=\"Land Rover\">Land Rover</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lexus\">Lexus</option>\r\n");
      out.write("\t\t\t\t<option value=\"Lifan\">Lifan</option>\r\n");
      out.write("\t\t\t\t<option value=\"Maserati\">Maserati</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mazda\">Mazda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mercedes-Benz\">Mercedes-Benz</option>\r\n");
      out.write("\t\t\t\t<option value=\"MG\">MG</option>\r\n");
      out.write("\t\t\t\t<option value=\"MINI\">MINI</option>\r\n");
      out.write("\t\t\t\t<option value=\"Mitsubishi\">Mitsubishi</option>\r\n");
      out.write("\t\t\t\t<option value=\"Nissan\">Nissan</option>\r\n");
      out.write("\t\t\t\t<option value=\"Opel\">Opel</option>\r\n");
      out.write("\t\t\t\t<option value=\"Peugeot\">Peugeot</option>\r\n");
      out.write("\t\t\t\t<option value=\"Porsche\">Porsche</option>\r\n");
      out.write("\t\t\t\t<option value=\"Renault\">Renault</option>\r\n");
      out.write("\t\t\t\t<option value=\"SEAT\">SEAT</option>\r\n");
      out.write("\t\t\t\t<option value=\"Skoda\">Skoda</option>\r\n");
      out.write("\t\t\t\t<option value=\"Smart\">Smart</option>\r\n");
      out.write("\t\t\t\t<option value=\"Suzuki\">Suzuki</option>\t\r\n");
      out.write("\t\t\t\t<option value=\"Subaru\">Subaru</option>\r\n");
      out.write("\t\t\t\t<option value=\"TESLA\">TESLA</option>\r\n");
      out.write("\t\t\t\t<option value=\"Toyota\">Toyota</option>\r\n");
      out.write("\t\t\t\t<option value=\"Volkswagen\">Volkswagen</option>\r\n");
      out.write("\t\t\t\t<option value=\"Volvo\">Volvo</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t<input name=\"idMarca\" id=\"idMarcaEdit\" type=\"hidden\">\r\n");
      out.write("\t<label>Modelo:</label> <input disabled id=\"modeloEdit\" class=\"form-control\" name=\"modelo\" type=\"text\">\r\n");
      out.write("\t<input name=\"idModelo\" id=\"idModeloEdit\" type=\"hidden\">\r\n");
      out.write("\t<label>Placa:</label> <input disabled id=\"placaEdit\" class=\"form-control\" name=\"placa\" type=\"text\">\r\n");
      out.write("\t<input name=\"idPlaca\" id=\"idPlacaEdit\" type=\"hidden\">\r\n");
      out.write("\t<label>Valor Total:</label> <input disabled id=\"valorEdit\" onBlur=\"SENAI.biblioteca.outroblur(this)\" class=\"form-control\" name=\"valor\" type=\"text\">\r\n");
      out.write("\t<input name=\"idValor\" id=\"idValorEdit\" value =\"R$\" type=\"hidden\">\r\n");
      out.write("\t<label>Data de serviço:</label> <input disabled id=\"dataEdit\" class=\"form-control\" name=\"data\" type=\"text\">\r\n");
      out.write("\t<input name=\"idData\" id=\"idDataEdit\" type=\"hidden\">\r\n");
      out.write("\t\r\n");
      out.write("\t<label>Método de pagamento:</label>\r\n");
      out.write("\t\t<select disabled class=\"form-control\" name=\"metodo\" id=\"metodoEdit\" class=\"form-control\" name=\"metodo\">\r\n");
      out.write("\t\t\t\t<option value=1>Dinheiro</option>\r\n");
      out.write("\t\t\t\t<option value=2>Cartão Débito</option>\r\n");
      out.write("\t\t\t\t<option value=3>Cartão Crédito</option>\r\n");
      out.write("\t\t\t\t<option value=4>PIX</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t<input name=\"idMetodo\" id=\"idMetodoEdit\" type=\"hidden\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!---------------------->\r\n");
      out.write("<div class=\"wrap\">\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write(" <div id=\"printThis\">\r\n");
      out.write("<div id=\"MyModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\" aria-hidden=\"true\">\r\n");
      out.write(" \r\n");
      out.write("  <div class=\"modal-dialog modal-lg\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Modal Content: begins -->\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      \r\n");
      out.write("      <!-- Modal Header -->\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("          <h4 class=\"modal-title\" id=\"gridSystemModalLabel\">Magalhães Auto Center</h4>\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("      <!-- Modal Body -->  \r\n");
      out.write("     \r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        <div id=\"test\" class=\"body-message\">\r\n");
      out.write("           \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("      <!-- Modal Footer -->\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("      <button id=\"btnPrint\" type=\"button\" style=\"width: 8% !important\"class=\"btn btn-default tf-printer\"></button>\r\n");
      out.write("       <button class=\"btn \" data-dismiss=\"modal\" aria-hidden=\"true\">Fechar</button>\r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Modal Content: ends -->\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"msg\" style=\"display: none\"></div>");
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
