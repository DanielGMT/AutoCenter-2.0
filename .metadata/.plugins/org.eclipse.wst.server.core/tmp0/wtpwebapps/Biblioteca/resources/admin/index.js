loadPage = function(caminho){
	
	var cfg = {
			type : "GET",
			url : "../../rest/bibliotecaRest/buscarUsuarioLogado/",
			success : function(usuario) {
				
				
					var cfg = {
							type : "POST",
							url : "../../rest/bibliotecaRest/buscarAdminPeloUsuario/" 
								+ usuario.login,
							
					success : function(admin) {
						
						var html = "";
						
						html += "<b>"+admin.nome+"</b>";
						
						$(".navbar-text").html(html);
						
						$('.foto').html('');
						html = "";
							$('.foto').removeClass("glyphicon-user");

					   
						html += "<img src='perfil/"+admin.imagem+"' class='img-rounded img-responsive' height=20 width=22></img>";
						$(".foto").html(html);
					},
					error : function(err) {
						alert("Erro ao buscar o admin "+ err.responseText);
					}
				};
					SENAI.ajax.post(cfg);	
				
				
					$(".ui-dialog").remove();
					if(caminho == "main"){
						window.location = "index.jsp";
					}else{
						$('#registerContent').html('');
					$("#registerContent").load(caminho+"/content.jsp");
					}
					
					
				
					
			},
		
			error : function(err) {
				alert("Erro ao conectar: "
						+ err.responseText);
			}
		};
	SENAI.ajax.post(cfg);
}





deslogar = function(){
	var cfg = {
			type : "POST",
			url : "../../rest/bibliotecaRest/deslogar/",
			success : function(sessao) {
				window.location = "../../index.html";	
			},
		
			error : function(err) {
				alert("Erro ao deslogar: "
						+ err.responseText);
			}
		};
	SENAI.ajax.post(cfg);
}