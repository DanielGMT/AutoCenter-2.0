  <%@ page import="br.com.BibliotecaRest.objetos.Sessao,br.com.BibliotecaRest.objetos.Usuario" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Magalhães Auto Center</title>
<!-- meta description -->
        <meta name="description" content="">      
        <!-- mobile viwport meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- fevicon -->
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
        
        <!-- ================================
        CSS Files
        ================================= -->
        <link href="https://fonts.googleapis.com/css?family=Libre+Baskerville:400,400i|Open+Sans:400,600,700,800" rel="stylesheet">
        <link rel="stylesheet" href="../../phantom/light/css/themefisher-fonts.min.css">
        <link rel="stylesheet" href="../../phantom/light/css/owl.carousel.min.css">
        <link rel="stylesheet" href="../../phantom/light/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../phantom/light/css/main.css">
        <link rel="stylesheet" href="../../phantom/light/css/dark.css">
        <link id="color-changer" rel="stylesheet" href="../../phantom/light/css/colors/red.css">
        <link rel="stylesheet" href="../css/jquery-ui.css">
        <link rel="stylesheet" href="navbar/css/navbar.css">
        <link rel="stylesheet" href="index.css">
	<link rel="stylesheet" href="cruds.css">
        
        
         <script src="../../phantom/light/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="../../phantom/light/js/vendor/bootstrap.min.js"></script>
        <!-- <script src="../../phantom/light/js/jquery.easing.min.js"></script> -->
        <script src="../../phantom/light/js/isotope.pkgd.min.js"></script>
        <script src="../../phantom/light/js/jquery.nicescroll.min.js"></script>
        <script src="../../phantom/light/js/owl.carousel.min.js"></script>
        <script src="../../phantom/light/js/jquery-validation.min.js"></script>
        <script src="../../phantom/light/js/form.min.js"></script>
        <script src="../../phantom/light/js/main.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js"></script>
<script type="text/javascript" src="canvasjs.min.js"></script>

<script src="relatorio/Chart.js"></script>


<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>


<script type="text/javascript" src="../js/jquery-ui.js"></script>

<script type="text/javascript" src="index.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>

</head>

 <body class="light">

<% 


Sessao sessao = Sessao.getInstance();

Usuario usuario = sessao.getUsuario();

if(usuario == null){
response.sendRedirect("../../index.html");
}


%>


 
<div class="container">

<div id="registerContent">
		 
      
	  <main class="site-wrapper">
            <div class="pt-table">
                <div class="pt-tablecell page-home relative" style="background-image: url('../../phantom/light/img/banner.jpg');">
                    <div class="overlay"></div>

                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
                                <div class="page-title home text-center">
                                    <h1>Magalhães Auto Center</h1>
                                </div>

                                <div class="hexagon-menu clear">
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" onclick="loadPage('main')" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-ion-ios-home"></i>
                                                </span>
                                                <span class="title">Início</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-profile-male"></i>
                                                </span>
                                                <span class="title">#</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" onclick="loadPage('autor')" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-tools-2"></i>
                                                </span>
                                                <span class="title">Serviços</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>    
                                    </div>
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" onclick="loadPage('relatorio')" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-bargraph"></i>
                                                </span>
                                                <span class="title">Relatório</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-briefcase2"></i>
                                                </span>
                                                <span class="title">#</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                  
                                    <div class="hexagon-item">
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <a href="#" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-envelope2"></i>
                                                </span>
                                                <span class="title">#</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                </div> <!-- /.hexagon-menu -->

                            </div> <!-- /.col-xs-12 -->

                        </div> <!-- /.row -->
                    </div> <!-- /.container -->

                </div> <!-- /.pt-tablecell -->
            </div> <!-- /.pt-table -->
        </main> <!-- /.site-wrapper -->
</div>

      

      

      

</div>
        
       
    </body>
</html>