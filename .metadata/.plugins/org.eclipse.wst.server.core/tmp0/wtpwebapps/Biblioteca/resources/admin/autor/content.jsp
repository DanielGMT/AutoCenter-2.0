<script type="text/javascript" src="autor/js/autor.js"></script>
<script type="text/javascript" src="imprimir/imprimir.js"></script>
<script type="text/javascript"src="autor/js/jquery.maskMoney.js"></script>
<script type="text/javascript"src="autor/js/jquery.mask.js"></script>

 <div  class="hexagon-menu clear">
                                    <div  class="hexagon-item">
                                        <div class="hex-item">
                                            
                                            <div></div>
                                            <div></div>
                                        </div>
                                        <div class="hex-item">
                                            <div></div>
                                            <div></div>
                                        
                                        </div>
                                        <a href="#" onclick="loadPage('main')" class="hex-content">
                                            <span class="hex-content-inner">
                                                <span class="icon">
                                                    <i class="tf-ion-ios-home"></i>
                                                </span>
                                                <span class="title">In?cio</span>
                                            </span>
                                            <svg viewbox="0 0 173.20508075688772 200" height="200" width="174" version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M86.60254037844386 0L173.20508075688772 50L173.20508075688772 150L86.60254037844386 200L0 150L0 50Z" fill="#1e2530"></path></svg>
                                        </a>
                                    </div>
                                    
                                </div> <!-- /.hexagon-menu -->


<div id="cadastrarAutor">
	<p>
		<button class="btn btn-primary" onclick="SENAI.biblioteca.descerPag()" id="downButton" type="button"
			data-toggle="collapse" data-target="#collapseExample"
			aria-expanded="false" aria-controls="collapseExample">
			Cadastrar Novo Servi?o <span class="caret"></span>
		</button>
	</p>
</div>

 
<div class="collapse" id="collapseExample">
	<form>
		<div class="form-group">
			<label for="servico">Servi?o</label>
			
				
				
			
			 <div id="lugarzinho">
			 <div>
			 	Item1<div><select id='servico0'><option value='Outro'>Outro</option><option value='Amortecedor dianteiro'>Amortecedor dianteiro</option><option value='Amortecedor trazeiro'>Amortecedor trazeiro</option><option value='Balanceamento'>Balanceamento</option><option value='Bico'>Bico</option><option value='Batente'>Batente</option><option value='Balan?a'>Balan?a</option><option value='Barra axial'>Barra axial</option><option value='Bieleta'>Bieleta</option><option value='Bucha da balan?a'>Bucha da balan?a</option><option value='Bucha da barra estabilizadora'>Bucha da barra estabilizadora</option><option value='Coifa do amortecedor'>Coifa do amortecedor</option><option value='Coifa da homocin?tica'>Coifa da homocin?tica</option><option value='Camara de Moto'>Camara de Moto</option><option value='Camara de Carro'>Camara de Carro</option><option value='Coxim'>Coxim</option><option value='Coxim de c?mbio'>Coxim de c?mbio</option><option value='Conserto de roda'>Conserto de roda</option><option value='Cubo dianteiro'>Cubo dianteiro</option><option value='Cubo trazeiro'>Cubo trazeiro</option><option value='Cilindro de freio'>Cilindro de freio</option><option value='Desempeno de Roda'>Desempeno de Roda</option><option value='Disco de freio dianteiro'>Disco de freio dianteiro</option><option value='Disco de freio trazeiro'>Disco de freio trazeiro</option><option value='Friso de pneu'>Friso de pneu</option><option value='Homocin?tica'>Homocin?tica</option><option value='Manuten??o'>Manuten??o</option><option value='M?o de obra'>M?o de obra</option><option value='Montagem'>Montagem</option><option value='Moto'>Moto</option><option value='Mola'>Mola</option><option value='Morceguinho'>Morceguinho</option><option value='Pastilha de freio dianteiro'>Pastilha de freio dianteiro</option><option value='Pastilha de freio trazeiro'>Pastilha de freio trazeiro</option><option value='Pneu 13'>Pneu 13</option><option value='Pneu 14'>Pneu 14</option><option value='Pneu 15'>Pneu 15</option><option value='Pneu 16'>Pneu 16</option><option value='Pneu 17'>Pneu 17</option><option value='Pneu 18'>Pneu 18</option><option value='Pneu 19'>Pneu 19</option><option value='Pneu 20'>Pneu 20</option><option value='Pneu 21'>Pneu 21</option><option value='Piv?'>Piv?</option><option value='Refil'>Refil</option><option value='Remendo frio'>Remendo frio</option><option value='Remendo quente'>Remendo quente</option><option value='Remendo de Camara'>Remendo de Camara</option><option value='Rebaixamento'>Rebaixamento</option><option value='Roda'>Roda</option><option value='Rod?zio'>Rod?zio</option><option value='Rolamento dianteiro'>Rolamento dianteiro</option><option value='Rolamento trazeiro'>Rolamento trazeiro</option><option value='Socorro'>Socorro</option><option value='Troca'>Troca</option><option value='Troca de bico'>Troca de bico</option><option value='Troca de calota'>Troca de calota</option><option value='Terminal de dire??o'>Terminal de dire??o</option><option value='Venda de pneu 13'>Venda de pneu 13</option><option value='Venda de pneu 14'>Venda de pneu 14</option><option value='Venda de pneu 15'>Venda de pneu 15</option><option value='Venda de pneu 16'>Venda de pneu 16</option><option value='Venda de pneu 17'>Venda de pneu 17</option><option value='Venda de pneu 18'>Venda de pneu 18</option><option value='Venda de pneu 19'>Venda de pneu 19</option><option value='Venda de pneu 20'>Venda de pneu 20</option><option value='Venda de roda'>Venda de roda</option><option value='Venda de Acess?rio'>Venda de Acess?rio</option><option value='Vulcanizo'>Vulcanizo</option><option value='Veda??o'>Veda??o</option></select>
				<select onChange='SENAI.biblioteca.selectQnt(this)' name='quantidade' id='quantidade0'><option value='1'>x1</option><option value='2'>x2</option><option value='3'>x3</option><option value='4'>x4</option><option value='5'>x5</option><option value='6'>x6</option><option value='7'>x7</option><option value='8'>x8</option><option value='9'>x9</option><option value='10'>x10</option></select><input class='form-control' id='item0' onblur= 'SENAI.biblioteca.blur(this)' autocomplete='off' placeholder='R$ (Valor Unit?rio)'><label class='control-label'></label></div>
						
			 </div>
			 </div>
			 	<a  class = "edit" onclick = "SENAI.biblioteca.acrescentarServico()">
			
				<i id="mais" class="tf-ion-plus" style="color: blue;"></i></a>
			 	<a  class = "edit" onclick = "SENAI.biblioteca.tirarServico()">
			 	&nbsp;
				<i id="menos" class="tf-ion-minus" style="color: red;"></i></a>
				
				




				<BR><BR>
				<div style="width: 50%; float: left;">
					<label for="valor">Valor Total</label><input disabled
					class="form-control" onblur="SENAI.biblioteca.teste(this)" value ="R$" autocomplete="off" type="text" id="inputvalor">
				</div>
				<div style="width: 50%; float: right;">
					<label for="data">Data de servi?o</label> <input
					class="form-control" autocomplete="off" type="date" id="inputdata">
				</div>
				<div style="width: 50%; float: left;">
					<label for="valor">Desconto: </label>
					<input style="background-color: #cd5c5c;" onblur="SENAI.biblioteca.outroblur(this)" placeholder="- R$" autocomplete="off" type="text" id="inputvalordesc">
				</div>
				
				<div style="width: 50%; float: left;">
					<label class = "control-label" for="observacao">Observa??o</label>
					<textarea class='form-control' id='inputobservacao' cols='20' autocomplete='off'></textarea>
				</div>
				
				<div style="width: 50%; float: left;">
					<label class="control-label" for="marca">Marca</label>
				<select class="form-control" name="marca" id="inputmarca">
				<option value="Outro">Outro</option>
				<option value="Abarth">Abarth</option>
				<option value="Alfa Romeo">Alfa Romeo</option>
				<option value="Alpine">Alpine</option>
				<option value="Aston Martin">Aston Martin</option>
				<option value="Audi">Audi</option>
				<option value="Bentley">Bentley</option>
				<option value="BMW">BMW</option>
				<option value="Citro?n">Citro?n</option>
				<option value="Chevrolet">Chevrolet</option>
				<option value="Cupra">Cupra</option>
				<option value="Dacia">Dacia</option>
				<option value="DS">DS</option>
				<option value="Ferrari">Ferrari</option>
				<option value="Fiat">Fiat</option>
				<option value="Ford">Ford</option>
				<option value="Hafei">Hafei</option>
				<option value="Honda">Honda</option>
				<option value="Hyundai">Hyundai</option>
				<option value="Jaguar">Jaguar</option>
				<option value="JEEP">JEEP</option>
				<option value="KIA">KIA</option>
				<option value="Lamborghini">Lamborghini</option>
				<option value="Land Rover">Land Rover</option>
				<option value="Lexus">Lexus</option>
				<option value="Lifan">Lifan</option>
				<option value="Maserati">Maserati</option>
				<option value="Mazda">Mazda</option>
				<option value="Mercedes-Benz">Mercedes-Benz</option>
				<option value="MG">MG</option>
				<option value="MINI">MINI</option>
				<option value="Mitsubishi">Mitsubishi</option>
				<option value="Nissan">Nissan</option>
				<option value="Opel">Opel</option>
				<option value="Peugeot">Peugeot</option>
				<option value="Porsche">Porsche</option>
				<option value="Renault">Renault</option>
				<option value="SEAT">SEAT</option>
				<option value="Skoda">Skoda</option>
				<option value="Smart">Smart</option>
				<option value="Suzuki">Suzuki</option>	
				<option value="Subaru">Subaru</option>
				<option value="TESLA">TESLA</option>
				<option value="Toyota">Toyota</option>
				<option value="Volkswagen">Volkswagen</option>
				<option value="Volvo">Volvo</option>
			</select></div><div style="width: 50%; float: right;">
			<label for="modelo">Modelo</label> <input class="form-control" autocomplete="on" id="inputmodelo">	
			
			
				
			</div>
			
	
	<div style="width: 50%; float: left;">
		<label for="placa">Placa</label> <input
		name="placas" class="form-control" autocomplete="off" type="text" id="inputplaca" placeholder="AAA-0000 / AAA0A00">
	</div>		
	<div style="width: 50%; float: right;">
	<label for="metodo">M?todo de pagamento *</label>
				<select class="form-control" name="metodo" id="inputmetodo">
					<option value=1>Dinheiro</option>
					<option value=2>D?bito</option>
					<option value=3>Cr?dito</option>
					<option value=4>PIX</option>
				</select>	
	</div>
	
	
		
		<div id="entrar" style="margin-left: 40%;">
		
			<button type="button" id="add-new"
				onclick="SENAI.biblioteca.cadastrarServico()" class="btn btn-primary">Registrar</button>
		</div>
	</div>	
	</form>
	
</div>

<div class="table-wrapper">
	<div class="col-md-12">
		<h2 class="pt-3 pb-4 text-center font-bold font-up deep-purple-text">Servi?os
			Registrados</h2>
		<div id="teste">
		
		
		<input type="date" onChange="SENAI.biblioteca.buscarServ()" id="searchDate" /><input type="date" onChange="SENAI.biblioteca.buscarServ()" id="searchDate2" />
		
		
		<select class="form-control" id="selectFiltro" onChange="SENAI.biblioteca.verificaResult(this)"><option style="display:none;" disabled value='50'>Filtrar</option><option style="background-color: #003d80; color: #d1d1d1;" value='0'>Total</option><option style="background-color: #003d80; color: #d1d1d1;" value='1'>Total de Hoje</option><option style="background-color: #1167b1; color: white;" value='3'>Hoje em Dinheiro</option><option style="background-color: #1167b1; color: white;" value='4'>Hoje em D?bito</option><option style="background-color: #1167b1; color: white;"  value='5'>Hoje em Cr?dito</option><option style="background-color: #1167b1; color: white;" value='6'>Hoje em Pix</option><option style="background-color: #2a9df4;" value='2'>?ltimos 30 Dias</option><option style="background-color: #2a9df4;" value='7'>?ltimos 30 Dias em Dinheiro</option><option style="background-color: #2a9df4;" value='8'>?ltimos 30 Dias em D?bito</option><option style="background-color: #2a9df4;" value='9'>?ltimos 30 Dias em Cr?dito</option><option style="background-color: #2a9df4;" value='10'>?ltimos 30 Dias em PIX</option></select>
			<input type="hidden" class="form-control" onChange="SENAI.biblioteca.buscarServico()" id="searchBar" />
		</div>
		<div><label for="totalglobal">Total L?quido: <br></label><input id="totalglobal" disabled name="totalglobal" type="text"></div>
	</div>
	<div class="resultadoServicos"></div>
<ul class="pagination">
    <li class="page-item">
      <a class="first" href="#"><<</a>
    </li>
    <li class="page-item">
      <a class="prev" href="#"><</a>
    </li>
   <li class="numbers">
   
   </li>
    <li class="page-item">
      <a class="next" href="#">></a>
    </li>
    <li class="page-item">
      <a class="last" href="#">>></a>
    </li>
  </ul>
	<div class="clearfix">
		<div class="hint-text"></div>
		
	</div>
</div>
<div id="editarServico" style="display: none">
	<label>Servi?o:</label> <textarea disabled id="servicoEdit" class="form-control" name="servico" type="text"></textarea>
	<input name="idServico" id="idServicoEdit" type="hidden">
	<label>Observa??o:</label>
	<textarea disabled class="form-control" id="observacaoEdit" cols="20" autocomplete="off"></textarea>
	<input name="idObservacao" id="idOservacaoEdit" type="hidden">
	<label>Marca:</label> <select disabled class="form-control" name="marca" id="marcaEdit">
				<option value="Outro">Outro</option>
				<option value="Abarth">Abarth</option>
				<option value="Alfa Romeo">Alfa Romeo</option>
				<option value="Alpine">Alpine</option>
				<option value="Aston Martin">Aston Martin</option>
				<option value="Audi">Audi</option>
				<option value="Bentley">Bentley</option>
				<option value="BMW">BMW</option>
				<option value="Citro?n">Citro?n</option>
				<option value="Chevrolet">Chevrolet</option>
				<option value="Cupra">Cupra</option>
				<option value="Dacia">Dacia</option>
				<option value="DS">DS</option>
				<option value="Ferrari">Ferrari</option>
				<option value="Fiat">Fiat</option>
				<option value="Ford">Ford</option>
				<option value="Hafei">Hafei</option>
				<option value="Honda">Honda</option>
				<option value="Hyundai">Hyundai</option>
				<option value="Jaguar">Jaguar</option>
				<option value="JEEP">JEEP</option>
				<option value="KIA">KIA</option>
				<option value="Lamborghini">Lamborghini</option>
				<option value="Land Rover">Land Rover</option>
				<option value="Lexus">Lexus</option>
				<option value="Lifan">Lifan</option>
				<option value="Maserati">Maserati</option>
				<option value="Mazda">Mazda</option>
				<option value="Mercedes-Benz">Mercedes-Benz</option>
				<option value="MG">MG</option>
				<option value="MINI">MINI</option>
				<option value="Mitsubishi">Mitsubishi</option>
				<option value="Nissan">Nissan</option>
				<option value="Opel">Opel</option>
				<option value="Peugeot">Peugeot</option>
				<option value="Porsche">Porsche</option>
				<option value="Renault">Renault</option>
				<option value="SEAT">SEAT</option>
				<option value="Skoda">Skoda</option>
				<option value="Smart">Smart</option>
				<option value="Suzuki">Suzuki</option>	
				<option value="Subaru">Subaru</option>
				<option value="TESLA">TESLA</option>
				<option value="Toyota">Toyota</option>
				<option value="Volkswagen">Volkswagen</option>
				<option value="Volvo">Volvo</option>
			</select>
	<input name="idMarca" id="idMarcaEdit" type="hidden">
	<label>Modelo:</label> <input disabled id="modeloEdit" class="form-control" name="modelo" type="text">
	<input name="idModelo" id="idModeloEdit" type="hidden">
	<label>Placa:</label> <input disabled id="placaEdit" class="form-control" name="placa" type="text">
	<input name="idPlaca" id="idPlacaEdit" type="hidden">
	<label>Valor Total:</label> <input disabled id="valorEdit" onBlur="SENAI.biblioteca.outroblur(this)" class="form-control" name="valor" type="text">
	<input name="idValor" id="idValorEdit" value ="R$" type="hidden">
	<label>Data de servi?o:</label> <input disabled id="dataEdit" class="form-control" name="data" type="text">
	<input name="idData" id="idDataEdit" type="hidden">
	
	<label>M?todo de pagamento:</label>
		<select disabled class="form-control" name="metodo" id="metodoEdit" class="form-control" name="metodo">
				<option value=1>Dinheiro</option>
				<option value=2>D?bito</option>
				<option value=3>Cr?dito</option>
				<option value=4>PIX</option>
			</select>
	<input name="idMetodo" id="idMetodoEdit" type="hidden">
</div>

<!---------------------->
<div class="wrap">
  
 
</div>
 <div id="printThis">
<div id="MyModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
 
  <div class="modal-dialog modal-lg">
    
    <!-- Modal Content: begins -->
    <div class="modal-content">
      
      <!-- Modal Header -->
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="gridSystemModalLabel">Magalh?es Auto Center</h4>
      </div>
    
      <!-- Modal Body -->  
     
      <div class="modal-body">
        <div id="test" class="body-message">
           
        </div>
      </div>
    
      <!-- Modal Footer -->
      <div class="modal-footer">
      <button id="btnPrint" type="button" style="width: 8% !important"class="btn btn-default tf-printer"></button>
       <button class="btn " data-dismiss="modal" aria-hidden="true">Fechar</button>
      
      </div>
    
    </div>
    <!-- Modal Content: ends -->
    
  </div>
    </div>
</div>


<div id="msg" style="display: none"></div>