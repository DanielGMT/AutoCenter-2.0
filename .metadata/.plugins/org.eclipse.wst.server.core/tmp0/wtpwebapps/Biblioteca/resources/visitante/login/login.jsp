<script type="text/javascript" src="resources/visitante/login/sincronizarDados.js"></script>
<script type="text/javascript" src="lalala.js"></script>

<div class="wrapper fadeInDown">
	<div id="formContent">
		<div class="fadeIn first">
			<img src="resources/visitante/login/images/download.png" id="icon" alt="User Icon" />
		</div>
		
		<form>
			<input id="username" type="text" class="fadeIn second" name="username" placeholder="usu�rio" />
			
				<input id="password" type="text" class="fadeIn third" name="password" autocomplete="off" placeholder="senha" /> 
								
		</form>
		
		<div id="msg">
			
		</div>
		<a href="#" id="entrar" onclick="SENAI.biblioteca.sincLogin();">Entrar</a>
		<div id="EsqueceuAsenha">
			<a class="underlineHover" onclick = "SENAI.biblioteca.abrirModal();" href="#">Esqueceu a senha?</a>
		</div>
	</div>
	
</div>
<div id="msg"></div>
<div id="exibirModal" style="display: none">
	<label id="titulos">Digite o email cadastrado:</label> 
	<input class="fadeIn third" id="umEmail" placeholder="email" name="email" type="text">
	
	
	
</div>	
