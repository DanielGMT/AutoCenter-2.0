SENAI.biblioteca = new Object();

$(document)
		.ready(
				function() {
					var tour = [];
					
					SENAI.biblioteca.cadastrarServico = function() {
						
										var str2 = new Date();
  					var str1 = new Date();
  					
							var dd2 = String(str2.getDate()).padStart(2, '0');
							var dd1 = String(str1.getDate()).padStart(2, '0');
							var mm2 = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
								var mm1 = String(str1.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy2 = str2.getFullYear();
							var yyyy1 = str1.getFullYear();
							
							str2 = dd2 + "/" + mm2 + "/" + yyyy2;
							str1 =  yyyy1+ "-" + mm1 + "-" + dd1;		
  						
  					
						
				
						
						var novoServico = new Object();
						for(i = 0; i < (linhas+1); i++){
							var conc = [];
							conc[i] = document.getElementById("item"+(i));
							var konk = [];
							konk[i] = document.getElementById("servico"+(i));
											var qtd = document.getElementById("quantidade"+(i));			
							
								outrasoma += (qtd.value)+"x " + new String(konk[i].value) + ", ";
							
							
							
								if(parseFloat(conc[i].value)>0){
										
													var doc = qtd.value;
													
														soma += parseFloat(conc[i].value*doc);
												
									}
							}
						
						soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
							document.getElementById("inputvalor").value = soma.toFixed(2);
							soma = 0;
							var outrasoma2 = outrasoma.substring(0, outrasoma.length - 2);
						novoServico.servico = outrasoma2+"."; 
						novoServico.observacao = $("#inputobservacao").val();
						novoServico.quantidade = qtd.value;
						outrasoma = "";
						novoServico.marca = $("#inputmarca").val();
						novoServico.modelo = $("#inputmodelo").val();
						novoServico.placa = $("#inputplaca").val();
						novoServico.valor = $("#inputvalor").val();
						novoServico.metodo = $("#inputmetodo").val();
						
						novoServico.data = $("#inputdata").val();
						
					
						
						
						document.getElementById("downButton").click();
								
					
						$("#inputobservacao").val("");
						
						$("#inputmarca").val("Outro");
						$("#inputmodelo").val("");
						$("#inputplaca").val("");
						$("#inputvalor").val(0);
						$("#inputmetodo").val(1);
						$("#inputvalordesc").val(0);
						
					$("#inputdata").val(str1);
						
						var teste = document.getElementById("lugarzinho");
						
						while(linhas>0){
							teste.removeChild(teste.lastChild);
							linhas = linhas - 1;
						}
							
								
						document.getElementById("item0").value = "";
						
						var cfgajax = {
							url : "../../rest/bibliotecaRest/addServico",
							data : novoServico,

							success : function(msg) {
								var cfg = {
									title : "Mensagem",
									height : 250,
									width : 400,
									modal : true,
									buttons : {
										"OK" : function() {
											$(this).dialog("close");
										}
									}
								};
								$("#msg").html(msg);
								$("#msg").dialog(cfg);

							
							
							if(document.getElementById("selectFiltro").value != 50){
								
								var valor = document.getElementById("selectFiltro");
								SENAI.biblioteca.verificaResult(valor);
							}else{
								
								SENAI.biblioteca.buscarServ();
								
							}
									
								
							
								
								
							},

							error : function(err) {
								alert("Erro ao cadastrar um novo servi??o!"
										+ err.responseText);
							}

						};

						SENAI.ajax.post(cfgajax);
						
						
					};

					
						
					  window.setInterval(function () {
							var str1 = new Date();
  							
							
							var dd1 = String(str1.getDate()).padStart(2, '0');
					
						
								var mm1 = String(str1.getMonth() + 1).padStart(2, '0'); //January is 0!
							
							var yyyy1 = str1.getFullYear();
							
						
							str1 =  yyyy1+ "-" + mm1 + "-" + dd1;	
							
							
					  
				        var d = new Date();
				        if (d.getHours() == 00) {
				          document.getElementById("inputdata").value = str1; 
				        }
				         if (d.getHours() == 06) {
				         document.getElementById("inputdata").value = "1999-12-12"; 
				        }
				
				    }, 5000);

					
					

							
					
					SENAI.biblioteca.buscarServico = function() {
						var valorBusca = $("#searchBar").val();
						SENAI.biblioteca.exibirServicos(undefined, valorBusca);
					};
					
					SENAI.biblioteca.buscarServ = function(){
						var valorBusca = $("#searchDate").val();
						var valorBusca2 = $("#searchDate2").val();
						$('#selectFiltro').val('50');
						SENAI.biblioteca.exibirServicosData(undefined, valorBusca, valorBusca2);
					}
					
					
					var dataHj = "";
					var date = new Date();
						
						
						if((date.getMonth()+1) < 10 || date.getDate() < 10){
							
							if(date.getDate() < 10){
								dataHj = date.getFullYear()+"-"+"0"+(date.getMonth()+1)+"-"+"0"+date.getDate();
							}else{
								dataHj = date.getFullYear()+"-"+"0"+(date.getMonth()+1)+"-"+date.getDate();
							}
						
						}else{
							dataHj = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();

						}
						
						
							
						
					SENAI.biblioteca.buscarServHj = function(){
						
								
						var valorBusca = dataHj;
						SENAI.biblioteca.exibirServicosData(undefined, valorBusca, null);
					}

					SENAI.biblioteca.buscarServMes = function(metodo){
						var um_mes = new Date();
						
						
						var dataMes = "";
						
						var mes = um_mes.getMonth();
						var ano = um_mes.getFullYear();
						var dia = um_mes.getDate();
						
						if(mes < 10 && dia < 10){
							if(mes < 1){
								mes = 12;
								ano = um_mes.getFullYear()-1;
							}
							
							dataMes = ano+"-0"+mes+"-0"+dia;
						}else if(mes < 10){
							
							if(mes < 1){
								mes = 12;
								ano = um_mes.getFullYear()-1;
							}
							dataMes = ano+"-0"+mes+"-"+dia;
							if(dia < 10){
								dataMes = ano+"-0"+mes+"-0"+dia;
							}
						}else if(dia < 10){
							if(mes < 1){
								mes = 12;
								ano = um_mes.getFullYear()-1;
							}
							
							dataMes = ano+"-"+mes+"-0"+dia;
							if(mes < 10){
								dataMes = ano+"-0"+mes+"-0"+dia;
							}
						}
						else{
							dataMes = ano+"-"+mes+"-"+dia;
						}
					
					
						
					
						var valorBuscaDe = dataHj;
						var valorBuscaAte = dataMes;
						
						SENAI.biblioteca.exibirServicosDataAte(undefined, valorBuscaDe, valorBuscaAte, metodo);
			
					}

					
					SENAI.biblioteca.buscaFiltro = function(valor){
						if(valor.value == 1){
							document.getElementById("divBusca").value = "<input type='date' class='form-control' onChange='SENAI.biblioteca.buscarServ()' id='searchDate' />";
						}else{
							document.getElementById("divBusca").value = "<input type='text' class='form-control' onChange='SENAI.biblioteca.buscarServico()' id='searchBar' placeholder='Buscar por modelo...' />";
			+ "<button id='searchButton' OnClick='SENAI.biblioteca.buscarServico()'>Buscar</button>";
						}
						
		
			
					}

					$(function() {
   						$("#inputvalor").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
						
						$("#inputvalordesc").maskMoney({prefix:'- R$ ', allowNegative: false, thousands:'.', decimal:',', affixesStay: false});
						
						$("#item0").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
  					
  					
  					var str2 = new Date();
  					var str1 = new Date();
  					
							var dd2 = String(str2.getDate()).padStart(2, '0');
							var dd1 = String(str1.getDate()).padStart(2, '0');
							var mm2 = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
								var mm1 = String(str1.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy2 = str2.getFullYear();
							var yyyy1 = str1.getFullYear();
							
							str2 = dd2 + "/" + mm2 + "/" + yyyy2;
							str1 =  yyyy1+ "-" + mm1 + "-" + dd1;		
  						
  						document.getElementById("inputdata").value =  str1;
  						
  					
  					});	
  					
  					$('input[name=placas]').mask('AAA 0U00', {
					    translation: {
					        'A': {
					            pattern: /[A-Za-z]/
					        },
					        'U': {
					            pattern: /[A-Za-z0-9]/
					        },
					    },
					    onKeyPress: function (value, e, field, options) {
					        // Convert to uppercase
					        e.currentTarget.value = value.toUpperCase();
					
					        // Get only valid characters
					        let val = value.replace(/[^\w]/g, '');
					
					        // Detect plate format
					        let isNumeric = !isNaN(parseFloat(val[4])) && isFinite(val[4]);
					        let mask = 'AAA 0U00';
					        if(val.length > 4 && isNumeric) {
					            mask = 'AAA-0000';
					        }
					        $(field).mask(mask, options);
					    }
					});
  					
  					var count = 0;
  					
					SENAI.biblioteca.exibirServicos = function(listaDeServicos,
							valorBusca) {
								
								
						var search = document.getElementById("searchBar");
						search.addEventListener("keyup", function(event) {
						  if (event.keyCode === 13) {
						   event.preventDefault();
						   document.getElementById("searchButton").click();
						  }
						});
						var html = "<table class='table table-bordered'>";
						html += "<tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo</th><th id='acao'>A????es</th></tr>";
						if (listaDeServicos != undefined
								&& listaDeServicos.length > 0) {
							
							let perPage = 12
							const state = {
							  page: 1,
							  perPage,
							  
							  totalPage: Math.ceil(listaDeServicos.length / perPage),
							  maxVisibleButtons: 5
							}
						 
						 const html = {
									get(element){
										return document.querySelector(element)
									}
							}

							

							
						
							
							const controls = {
							  next(){
							    state.page++
							   
							    const lastPage = state.page > state.totalPage
							    if(lastPage) {
							    	state.page--
							    }
							    
							  },
							  prev(){
								  state.page--
								  if(state.page < 1){
									  state.page++
								  }
								  
							  },
							  goTo(page){
								 state.page = +page
								 
							   },
							
							  createListeners() {
								 
								  
								  html.get('.next').addEventListener('click', () => {
									  controls.next()
									  update()
								  })
								  
								  html.get('.prev').addEventListener('click', () => {
									  controls.prev()
									  update()
								  })
								  
								 html.get('.last').addEventListener('click', () => {
									  controls.goTo(state.totalPage)
									  update()
								  })
								   
								  html.get('.first').addEventListener('click', () => {
									  controls.goTo(1)
									  update()
								  })}
								 
							  
							}
							
							var str1 = "";
	
							var n = "";
							var date = new Date();
							var str2 = new Date();
							var dd = String(str2.getDate()).padStart(2, '0');
							var mm = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy = str2.getFullYear();
							
							str2 = dd + "/" + mm + "/" + yyyy;
						 var msg = "";
							const list = {
									
									create(item){
										var tr = document.createElement('tr')
										
										totalglobal = item.total;
										
										var itemvalor = item.valor;
										
										document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
										tr.innerHTML += "<td class='ellipsis'>"
											+ item.servico
											+ "</td>"
											+"<td>"
											+ item.marca
											+ "</td>"
											+"<td>"
											+ item.modelo
											+ "</td>"
											+"<td>"
											+ item.placa
											+ "</td>"
											+"<td>"
											+ "R$ "+itemvalor.toFixed(2)
											+ "</td>";
											
											if(item.metodo == 1){
												tr.innerHTML += "<td>Dinheiro</td>";
											}else if(item.metodo == 2){
												tr.innerHTML += "<td>D??bito</td>";
											}else if(item.metodo == 3){
												tr.innerHTML += "<td>Cr??dito</td>";
											}else{
												tr.innerHTML += "<td>Pix</td>";
											}
											tr.innerHTML += "<td>"+item.data+"</td>"
											
										+ "<td><button class='tf-ion-eye' onclick = 'SENAI.biblioteca.editarServico("
											+ item.id
											+ "); '>"
											+ "</button>"
											+ " <button type='button' class='tf-printer' data-toggle='modal' onclick='SENAI.biblioteca.imprimirServico("+item.id+")' data-target='#MyModal'></button>"
											+ "<button class='tf-ion-trash-a' onclick = 'SENAI.biblioteca.deletarServico("
											+ item.id
											+ ")'>"
											+ "</button></td>";	
										
										html.get('.fleinin').appendChild(tr);
										
		
							},
							createTable(){
								const table = document.createElement('table')
								table.classList.add('table')
								table.classList.add('table-bordered')
								
								table.innerHTML += "<tbody class ='fleinin'><tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo de P.</th><th>Data de Servi??o</th><th>A????es</th></tr>"
								+ "</tbody>";
								html.get('.resultadoServicos').appendChild(table);
							},
							update(){
								 
								 html.get('.resultadoServicos').innerHTML = ""
									 list.createTable()
								let page = state.page - 1
								let start = page * state.perPage
								let end = start + state.perPage
								const paginatedItems = listaDeServicos.slice(start, end)
								
								paginatedItems.forEach(list.create);
							 }
							 
					 	}
						
						
						
						const buttons = {
								element: html.get('.pagination .numbers'),
								create(number) {
									const button = document.createElement('a')
									
									button.innerHTML = number;
									
									if(state.page == number){
										button.classList.add('active')
									}
									
									button.addEventListener('click', (event) => {
										const page = event.target.innerText
										
										controls.goTo(page)
										
										update()
									})
									
									buttons.element.appendChild(button)
								},
								update() {
									buttons.element.innerHTML = ""
										const {maxLeft, maxRight} = buttons.calculateMaxVisible()
										
										
										for(let page = maxLeft; page<=maxRight; page++){
											buttons.create(page)
										}
								},
								calculateMaxVisible(){
									const { maxVisibleButtons } = state
									let maxLeft = (state.page - Math.floor(maxVisibleButtons / 2))
									let maxRight = (state.page + Math.floor(maxVisibleButtons / 2))
								 if(maxLeft < 1){
									 maxLeft = 1
									 maxRight = maxVisibleButtons
								 }
									if(maxRight > state.totalPage){
										maxLeft = state.totalPage - (maxVisibleButtons - 1)
										maxRight = state.totalPage
										
										if(maxLeft < 1){
											maxLeft = 1
										}
									}
									
									return {maxLeft, maxRight}
								}
						}
						
						function update() {
							list.update()
					 		buttons.update()
					 	}
					 
					 	function init(){
					 		update()
					 		controls.createListeners()
					 	}
					 	
					 	init();
							
						
						} else {
							if (listaDeServicos == undefined) {
								if (valorBusca == "") {
									valorBusca = null;
								}
								var cfg = {
									type : "POST",
									url : "../../rest/bibliotecaRest/buscarServicosPorNome/"
											+ valorBusca,
									success : function(listaDeServicos) {
										SENAI.biblioteca
												.exibirServicos(listaDeServicos);
												
									},
									error : function(err) {
										alert("Erro ao consultar os Servicos: "
												+ err.responseText);
									}
								};

								SENAI.ajax.post(cfg);
							
								
								

								SENAI.ajax.post(cfg);
							} else {
								const html = {
										get(element){
											return document.querySelector(element)
										}
								}
								totalglobal = 0;
								document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
								html.get('.resultadoServicos').innerHTML = "<span><label><font color='red'> Nenhum registro encontrado. </font></label></span>";
								
							}
						}
						
					};
					
					var count = 1;
					var valor = parseFloat(0);
					var testando = "";			


					
					SENAI.biblioteca.exibirServicosData = function(listaDeServicos,
							valorBusca, valorBusca2) {
								
						var search = document.getElementById("searchBar");
						search.addEventListener("keyup", function(event) {
						  if (event.keyCode === 13) {
						   event.preventDefault();
						   document.getElementById("searchButton").click();
						  }
						});
						var html = "<table class='table table-bordered'>";
						html += "<tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo</th><th id='acao'>A????es</th></tr>";
						if (listaDeServicos != undefined
								&& listaDeServicos.length > 0) {
							
							let perPage = 12
							const state = {
							  page: 1,
							  perPage,
							  
							  totalPage: Math.ceil(listaDeServicos.length / perPage),
							  maxVisibleButtons: 5
							}
						 
						 const html = {
									get(element){
										return document.querySelector(element)
									}
							}

							

							
						
							
							const controls = {
							  next(){
							    state.page++
							   
							    const lastPage = state.page > state.totalPage
							    if(lastPage) {
							    	state.page--
							    }
							    
							  },
							  prev(){
								  state.page--
								  if(state.page < 1){
									  state.page++
								  }
								  
							  },
							  goTo(page){
								 state.page = +page
								 
							   },
							
							  createListeners() {
								 
								  
								  html.get('.next').addEventListener('click', () => {
									  controls.next()
									  update()
								  })
								  
								  html.get('.prev').addEventListener('click', () => {
									  controls.prev()
									  update()
								  })
								  
								 html.get('.last').addEventListener('click', () => {
									  controls.goTo(state.totalPage)
									  update()
								  })
								   
								  html.get('.first').addEventListener('click', () => {
									  controls.goTo(1)
									  update()
								  })}
								 
							  
							}
							
							var str1 = "";
	
							var n = "";
							var date = new Date();
							var str2 = new Date();
							var dd = String(str2.getDate()).padStart(2, '0');
							var mm = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy = str2.getFullYear();
							
							str2 = dd + "/" + mm + "/" + yyyy;
						 var msg = "";
							const list = {
									
									create(item){
										var tr = document.createElement('tr')
										
										totalglobal = item.total;
										
										var itemvalor = item.valor;
										document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
										tr.innerHTML += "<td>"
											+ item.servico
											+ "</td>"
											+"<td>"
											+ item.marca
											+ "</td>"
											+"<td>"
											+ item.modelo
											+ "</td>"
											+"<td>"
											+ item.placa
											+ "</td>"
											+"<td>"
											+ "R$ "+itemvalor.toFixed(2)
											+ "</td>";
											
											if(item.metodo == 1){
												tr.innerHTML += "<td>Dinheiro</td>";
											}else if(item.metodo == 2){
												tr.innerHTML += "<td>D??bito</td>";
											}else if(item.metodo == 3){
												tr.innerHTML += "<td>Cr??dito</td>";
											}else{
												tr.innerHTML += "<td>Pix</td>";
											}
											tr.innerHTML += "<td>"+item.data+"</td>"
											
											+ "<td><button class='tf-ion-eye' onclick = 'SENAI.biblioteca.editarServico("
											+ item.id
											+ "); '>"
											+ "</button>"
											+ " <button type='button' class='tf-printer' data-toggle='modal' onclick='SENAI.biblioteca.imprimirServico("+item.id+")' data-target='#MyModal'></button>"
											+ "<button class='tf-ion-trash-a' onclick = 'SENAI.biblioteca.deletarServico("
											+ item.id
											+ ")'>"
											+ "</button></td>";	
										
										html.get('.fleinin').appendChild(tr);
										
		
							},
							createTable(){
								const table = document.createElement('table')
								table.classList.add('table')
								table.classList.add('table-bordered')
								
								table.innerHTML += "<tbody class ='fleinin'><tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo de P.</th><th>Data de Servi??o</th><th>A????es</th></tr>"
								+ "</tbody>";
								html.get('.resultadoServicos').appendChild(table);
							},
							update(){
								 
								 html.get('.resultadoServicos').innerHTML = ""
									 list.createTable()
								let page = state.page - 1
								let start = page * state.perPage
								let end = start + state.perPage
								const paginatedItems = listaDeServicos.slice(start, end)
								
								paginatedItems.forEach(list.create);
							 }
							 
					 	}
						
						
						
						const buttons = {
								element: html.get('.pagination .numbers'),
								create(number) {
									const button = document.createElement('a')
									
									button.innerHTML = number;
									
									if(state.page == number){
										button.classList.add('active')
									}
									
									button.addEventListener('click', (event) => {
										const page = event.target.innerText
										
										controls.goTo(page)
										update()
									})
									
									buttons.element.appendChild(button)
								},
								update() {
									buttons.element.innerHTML = ""
										const {maxLeft, maxRight} = buttons.calculateMaxVisible()
										
										
										for(let page = maxLeft; page<=maxRight; page++){
											buttons.create(page)
										}
								},
								calculateMaxVisible(){
									const { maxVisibleButtons } = state
									let maxLeft = (state.page - Math.floor(maxVisibleButtons / 2))
									let maxRight = (state.page + Math.floor(maxVisibleButtons / 2))
								 if(maxLeft < 1){
									 maxLeft = 1
									 maxRight = maxVisibleButtons
								 }
									if(maxRight > state.totalPage){
										maxLeft = state.totalPage - (maxVisibleButtons - 1)
										maxRight = state.totalPage
										
										if(maxLeft < 1){
											maxLeft = 1
										}
									}
									
									return {maxLeft, maxRight}
								}
						}
						
						function update() {
							list.update()
					 		buttons.update()
					 	}
					 
					 	function init(){
					 		update()
					 		controls.createListeners()
					 	}
					 	
					 	init();
							
						
						} else {
							if (listaDeServicos == undefined) {
								if (valorBusca == "") {
									valorBusca = null;
								}
								if (valorBusca2 == ""){
									valorBusca2 = null;
								}
								
								var cfg = {
									type : "POST",
									url : "../../rest/bibliotecaRest/buscarServicosPorData/"+valorBusca+"/"+valorBusca2,
									success : function(listaDeServicos) {
										SENAI.biblioteca
												.exibirServicosData(listaDeServicos);
												
									},
									error : function(err) {
										alert("Erro ao consultar os Servicos: "
												+ err.responseText);
									}
								};

								SENAI.ajax.post(cfg);
								
															} else {
								const html = {
										get(element){
											return document.querySelector(element)
										}
								}
								totalglobal = 0;
								document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
								html.get('.resultadoServicos').innerHTML = "<span><label><font color='red'> Nenhum registro encontrado. </font></label></span>";
								
							}
						}
						
					};

					
					SENAI.biblioteca.descerPag = function(){
						window.scrollTo(5, 5);
						
							var str2 = new Date();
  					var str1 = new Date();
  					
							var dd2 = String(str2.getDate()).padStart(2, '0');
							var dd1 = String(str1.getDate()).padStart(2, '0');
							var mm2 = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
								var mm1 = String(str1.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy2 = str2.getFullYear();
							var yyyy1 = str1.getFullYear();
							
							str2 = dd2 + "/" + mm2 + "/" + yyyy2;
							str1 =  yyyy1+ "-" + mm1 + "-" + dd1;		
  						
  						document.getElementById("inputdata").value =  str1;
						
					}
					
					SENAI.biblioteca.tirarServico = function(){
						

						
						const html = {
										get(element){
											return document.querySelector(element)
										}
								}
						
						var teste = document.getElementById("lugarzinho");
						
						
							
								
							
							
							if(linhas>0){
								teste.removeChild(teste.lastChild);
							linhas = linhas - 1;
								
								for(i = 0; i < (linhas+1); i++){
									var conc = [];
									conc[i] = document.getElementById("item"+(i));
							
									if(parseFloat(conc[i].value) > 0){
											var qtd = document.getElementById("quantidade"+(i));
											var doc = qtd.value;
											
												soma += parseFloat(conc[i].value*doc);
											
											
										
									}
																$("#item"+(i)).maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});

							}
							
							soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
							document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
							
						
						}	
						soma = 0;
					
						count = 1;
							
					}


			SENAI.biblioteca.exibirServicosDataHj = function(listaDeServicos,
							valorBusca, metodo) {
								
						var search = document.getElementById("searchBar");
						search.addEventListener("keyup", function(event) {
						  if (event.keyCode === 13) {
						   event.preventDefault();
						   document.getElementById("searchButton").click();
						  }
						});
						var html = "<table class='table table-bordered'>";
						html += "<tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo</th><th id='acao'>A????es</th></tr>";
						if (listaDeServicos != undefined
								&& listaDeServicos.length > 0) {
							
							let perPage = 12
							const state = {
							  page: 1,
							  perPage,
							  
							  totalPage: Math.ceil(listaDeServicos.length / perPage),
							  maxVisibleButtons: 5
							}
						 
						 const html = {
									get(element){
										return document.querySelector(element)
									}
							}

							

							
						
							
							const controls = {
							  next(){
							    state.page++
							   
							    const lastPage = state.page > state.totalPage
							    if(lastPage) {
							    	state.page--
							    }
							    
							  },
							  prev(){
								  state.page--
								  if(state.page < 1){
									  state.page++
								  }
								  
							  },
							  goTo(page){
								 state.page = +page
								 
							   },
							
							  createListeners() {
								 
								  
								  html.get('.next').addEventListener('click', () => {
									  controls.next()
									  update()
								  })
								  
								  html.get('.prev').addEventListener('click', () => {
									  controls.prev()
									  update()
								  })
								  
								 html.get('.last').addEventListener('click', () => {
									  controls.goTo(state.totalPage)
									  update()
								  })
								   
								  html.get('.first').addEventListener('click', () => {
									  controls.goTo(1)
									  update()
								  })}
								 
							  
							}
							
							var str1 = "";
	
							var n = "";
							var date = new Date();
							var str2 = new Date();
							var dd = String(str2.getDate()).padStart(2, '0');
							var mm = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy = str2.getFullYear();
							
							str2 = dd + "/" + mm + "/" + yyyy;
						 var msg = "";
							const list = {
									
									create(item){
										var tr = document.createElement('tr')
										
										totalglobal = item.total;
										
										var itemvalor = item.valor;
										document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
										tr.innerHTML += "<td>"
											+ item.servico
											+ "</td>"
											+"<td>"
											+ item.marca
											+ "</td>"
											+"<td>"
											+ item.modelo
											+ "</td>"
											+"<td>"
											+ item.placa
											+ "</td>"
											+"<td>"
											+ "R$ "+itemvalor.toFixed(2)
											+ "</td>";
											
											if(item.metodo == 1){
												tr.innerHTML += "<td>Dinheiro</td>";
											}else if(item.metodo == 2){
												tr.innerHTML += "<td>D??bito</td>";
											}else if(item.metodo == 3){
												tr.innerHTML += "<td>Cr??dito</td>";
											}else{
												tr.innerHTML += "<td>Pix</td>";
											}
											tr.innerHTML += "<td>"+item.data+"</td>"
											
											+ "<td><button class='tf-ion-eye' onclick = 'SENAI.biblioteca.editarServico("
											+ item.id
											+ "); '>"
											+ "</button>"
											+ " <button type='button' class='tf-printer' data-toggle='modal' onclick='SENAI.biblioteca.imprimirServico("+item.id+")' data-target='#MyModal'></button>"
											+ "<button class='tf-ion-trash-a' onclick = 'SENAI.biblioteca.deletarServico("
											+ item.id
											+ ")'>"
											+ "</button></td>";	
										
										html.get('.fleinin').appendChild(tr);
										
		
							},
							createTable(){
								const table = document.createElement('table')
								table.classList.add('table')
								table.classList.add('table-bordered')
								
								table.innerHTML += "<tbody class ='fleinin'><tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo de P.</th><th>Data de Servi??o</th><th>A????es</th></tr>"
								+ "</tbody>";
								html.get('.resultadoServicos').appendChild(table);
							},
							update(){
								 
								 html.get('.resultadoServicos').innerHTML = ""
									 list.createTable()
								let page = state.page - 1
								let start = page * state.perPage
								let end = start + state.perPage
								const paginatedItems = listaDeServicos.slice(start, end)
								
								paginatedItems.forEach(list.create);
							 }
							 
					 	}
						
						
						
						const buttons = {
								element: html.get('.pagination .numbers'),
								create(number) {
									const button = document.createElement('a')
									
									button.innerHTML = number;
									
									if(state.page == number){
										button.classList.add('active')
									}
									
									button.addEventListener('click', (event) => {
										const page = event.target.innerText
										
										controls.goTo(page)
										update()
									})
									
									buttons.element.appendChild(button)
								},
								update() {
									buttons.element.innerHTML = ""
										const {maxLeft, maxRight} = buttons.calculateMaxVisible()
										
										
										for(let page = maxLeft; page<=maxRight; page++){
											buttons.create(page)
										}
								},
								calculateMaxVisible(){
									const { maxVisibleButtons } = state
									let maxLeft = (state.page - Math.floor(maxVisibleButtons / 2))
									let maxRight = (state.page + Math.floor(maxVisibleButtons / 2))
								 if(maxLeft < 1){
									 maxLeft = 1
									 maxRight = maxVisibleButtons
								 }
									if(maxRight > state.totalPage){
										maxLeft = state.totalPage - (maxVisibleButtons - 1)
										maxRight = state.totalPage
										
										if(maxLeft < 1){
											maxLeft = 1
										}
									}
									
									return {maxLeft, maxRight}
								}
						}
						
						function update() {
							list.update()
					 		buttons.update()
					 	}
					 
					 	function init(){
					 		update()
					 		controls.createListeners()
					 	}
					 	
					 	init();
							
						
						} else {
							if (listaDeServicos == undefined) {
								if (valorBusca == "" || metodo == "") {
									valorBusca = null;
									metodo = null;
								}
								
								var cfg = {
									type : "POST",
									url : "../../rest/bibliotecaRest/buscarServicosPorDataHj/"+valorBusca+"/"+metodo,
									
									success : function(listaDeServicos) {
										SENAI.biblioteca
												.exibirServicosDataHj(listaDeServicos);
									},
									error : function(err) {
										alert("Erro ao consultar os Servicos: "
												+ err.responseText);
									}
								};

								SENAI.ajax.post(cfg);
								
															} else {
								const html = {
										get(element){
											return document.querySelector(element)
										}
								}
								totalglobal = 0;
								document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);

								html.get('.resultadoServicos').innerHTML = "<span><label><font color='red'> Nenhum registro encontrado. </font></label></span>";
							}
						}
						
					};



			

			SENAI.biblioteca.exibirServicosDataAte = function(listaDeServicos,
							valorBuscaDe, valorBuscaAte, metodo) {
								
						var search = document.getElementById("searchBar");
						search.addEventListener("keyup", function(event) {
						  if (event.keyCode === 13) {
						   event.preventDefault();
						   document.getElementById("searchButton").click();
						  }
						});
						var html = "<table class='table table-bordered'>";
						html += "<tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo</th><th id='acao'>A????es</th></tr>";
						if (listaDeServicos != undefined
								&& listaDeServicos.length > 0) {
							
							let perPage = 12
							const state = {
							  page: 1,
							  perPage,
							  
							  totalPage: Math.ceil(listaDeServicos.length / perPage),
							  maxVisibleButtons: 5
							}
						 
						 const html = {
									get(element){
										return document.querySelector(element)
									}
							}

							

							
						
							
							const controls = {
							  next(){
							    state.page++
							   
							    const lastPage = state.page > state.totalPage
							    if(lastPage) {
							    	state.page--
							    }
							    
							  },
							  prev(){
								  state.page--
								  if(state.page < 1){
									  state.page++
								  }
								  
							  },
							  goTo(page){
								 state.page = +page
								 
							   },
							
							  createListeners() {
								 
								  
								  html.get('.next').addEventListener('click', () => {
									  controls.next()
									  update()
								  })
								  
								  html.get('.prev').addEventListener('click', () => {
									  controls.prev()
									  update()
								  })
								  
								 html.get('.last').addEventListener('click', () => {
									  controls.goTo(state.totalPage)
									  update()
								  })
								   
								  html.get('.first').addEventListener('click', () => {
									  controls.goTo(1)
									  update()
								  })}
								 
							  
							}
							
							var str1 = "";
	
							var n = "";
							var date = new Date();
							var str2 = new Date();
							var dd = String(str2.getDate()).padStart(2, '0');
							var mm = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
							var yyyy = str2.getFullYear();
							
							str2 = dd + "/" + mm + "/" + yyyy;
						 var msg = "";
							const list = {
									
									create(item){
										var tr = document.createElement('tr')
										
										totalglobal = item.total;
									
										var itemvalor = item.valor;
										document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
										tr.innerHTML += "<td>"
											+ item.servico
											+ "</td>"
											+"<td>"
											+ item.marca
											+ "</td>"
											+"<td>"
											+ item.modelo
											+ "</td>"
											+"<td>"
											+ item.placa
											+ "</td>"
											+"<td>"
											+ "R$ "+itemvalor.toFixed(2)
											+ "</td>";
											
											if(item.metodo == 1){
												tr.innerHTML += "<td>Dinheiro</td>";
											}else if(item.metodo == 2){
												tr.innerHTML += "<td>D??bito</td>";
											}else if(item.metodo == 3){
												tr.innerHTML += "<td>Cr??dito</td>";
											}else{
												tr.innerHTML += "<td>Pix</td>";
											}
											tr.innerHTML += "<td>"+item.data+"</td>"
											
											+ "<td><button class='tf-ion-eye' onclick = 'SENAI.biblioteca.editarServico("
											+ item.id
											+ "); '>"
											+ "</button>"
											+ " <button type='button' class='tf-printer' data-toggle='modal' onclick='SENAI.biblioteca.imprimirServico("+item.id+")' data-target='#MyModal'></button>"
											+ "<button class='tf-ion-trash-a' onclick = 'SENAI.biblioteca.deletarServico("
											+ item.id
											+ ")'>"
											+ "</button></td>";		
										
										html.get('.fleinin').appendChild(tr);
										
		
							},
							createTable(){
								const table = document.createElement('table')
								table.classList.add('table')
								table.classList.add('table-bordered')
								
								table.innerHTML += "<tbody class ='fleinin'><tr><th>Servi??o</th><th>Marca</th><th>Modelo</th><th>Placa</th><th>Valor</th><th>M??todo de P.</th><th>Data de Servi??o</th><th>A????es</th></tr>"
								+ "</tbody>";
								html.get('.resultadoServicos').appendChild(table);
							},
							update(){
								 
								 html.get('.resultadoServicos').innerHTML = ""
									 list.createTable()
								let page = state.page - 1
								let start = page * state.perPage
								let end = start + state.perPage
								const paginatedItems = listaDeServicos.slice(start, end)
								
								paginatedItems.forEach(list.create);
							 }
							 
					 	}
						
						
						
						const buttons = {
								element: html.get('.pagination .numbers'),
								create(number) {
									const button = document.createElement('a')
									
									button.innerHTML = number;
									
									if(state.page == number){
										button.classList.add('active')
									}
									
									button.addEventListener('click', (event) => {
										const page = event.target.innerText
										
										controls.goTo(page)
										update()
									})
									
									buttons.element.appendChild(button)
								},
								update() {
									buttons.element.innerHTML = ""
										const {maxLeft, maxRight} = buttons.calculateMaxVisible()
										
										
										for(let page = maxLeft; page<=maxRight; page++){
											buttons.create(page)
										}
								},
								calculateMaxVisible(){
									const { maxVisibleButtons } = state
									let maxLeft = (state.page - Math.floor(maxVisibleButtons / 2))
									let maxRight = (state.page + Math.floor(maxVisibleButtons / 2))
								 if(maxLeft < 1){
									 maxLeft = 1
									 maxRight = maxVisibleButtons
								 }
									if(maxRight > state.totalPage){
										maxLeft = state.totalPage - (maxVisibleButtons - 1)
										maxRight = state.totalPage
										
										if(maxLeft < 1){
											maxLeft = 1
										}
									}
									
									return {maxLeft, maxRight}
								}
						}
						
						function update() {
							list.update()
					 		buttons.update()
					 	}
					 
					 	function init(){
					 		update()
					 		controls.createListeners()
					 	}
					 	
					 	init();
							
						
						} else {
							if (listaDeServicos == undefined) {
								if (valorBuscaAte == "" || valorBuscaDe == "") {
									valorBuscaAte = null;
									valorBuscaDe = null;
								}
								
								var cfg = {
									type : "POST",
									url : "../../rest/bibliotecaRest/buscarServicosPorDataAte/"+valorBuscaDe+"/"+valorBuscaAte+"/"+metodo,
									
									success : function(listaDeServicos) {
										SENAI.biblioteca
												.exibirServicosDataAte(listaDeServicos);
									},
									error : function(err) {
										alert("Erro ao consultar os Servicos: "
												+ err.responseText);
									}
								};

								SENAI.ajax.post(cfg);
								
															} else {
								const html = {
										get(element){
											return document.querySelector(element)
										}
								}
								totalglobal = 0;
								document.getElementById("totalglobal").value = "R$ "+totalglobal.toFixed(2);
								html.get('.resultadoServicos').innerHTML = "<span><label><font color='red'> Nenhum registro encontrado. </font></label></span>";
								
							}
						}
						
					};

					
					
					
					 var linhas = 0;
					 var date = new Date();
						var str2 = new Date();
						var dd = String(str2.getDate()).padStart(2, '0');
						var mm = String(str2.getMonth() + 1).padStart(2, '0'); //January is 0!
						var yyyy = String(str2.getFullYear());

						str2 = yyyy + "-" + mm + "-" + dd;
						
					
					
					
					SENAI.biblioteca.acrescentarServico = function(){
						
						
						
							var test = document.getElementById("item"+(linhas+1));
							soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
							document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
						
							
						soma = 0;
					
						
						testando = "";
							
						
						var text = "";

								const html = {
										get(element){
											return document.querySelector(element)
										}
								}				
					

						linhas += 1;
							
							
							
							var div = document.getElementById("lugarzinho");
						
						var divtest = document.createElement("div")
						
						divtest.innerHTML = "Item"+(linhas+1)+"<div><select id='servico"+linhas+"' autocomplete='off'><option value='Outro'>Outro</option><option value='Amortecedor dianteiro'>Amortecedor dianteiro</option><option value='Amortecedor trazeiro'>Amortecedor trazeiro</option><option value='Balanceamento'>Balanceamento</option><option value='Bico'>Bico</option><option value='Batente'>Batente</option><option value='Balan??a'>Balan??a</option><option value='Barra axial'>Barra axial</option><option value='Bieleta'>Bieleta</option><option value='Bucha da balan??a'>Bucha da balan??a</option><option value='Bucha da barra estabilizadora'>Bucha da barra estabilizadora</option><option value='Coifa do amortecedor'>Coifa do amortecedor</option><option value='Coifa da homocin??tica'>Coifa da homocin??tica</option><option value='Camara de Moto'>Camara de Moto</option><option value='Camara de Carro'>Camara de Carro</option><option value='Coxim'>Coxim</option><option value='Coxim de c??mbio'>Coxim de c??mbio</option><option value='Conserto de roda'>Conserto de roda</option><option value='Cubo dianteiro'>Cubo dianteiro</option><option value='Cubo trazeiro'>Cubo trazeiro</option><option value='Cilindro de freio'>Cilindro de freio</option><option value='Desempeno de Roda'>Desempeno de Roda</option><option value='Disco de freio dianteiro'>Disco de freio dianteiro</option><option value='Disco de freio trazeiro'>Disco de freio trazeiro</option><option value='Friso de pneu'>Friso de pneu</option><option value='Homocin??tica'>Homocin??tica</option><option value='Manuten????o'>Manuten????o</option><option value='M??o de obra'>M??o de obra</option><option value='Montagem'>Montagem</option><option value='Moto'>Moto</option><option value='Mola'>Mola</option><option value='Morceguinho'>Morceguinho</option><option value='Pastilha de freio dianteiro'>Pastilha de freio dianteiro</option><option value='Pastilha de freio trazeiro'>Pastilha de freio trazeiro</option><option value='Pneu 13'>Pneu 13</option><option value='Pneu 14'>Pneu 14</option><option value='Pneu 15'>Pneu 15</option><option value='Pneu 16'>Pneu 16</option><option value='Pneu 17'>Pneu 17</option><option value='Pneu 18'>Pneu 18</option><option value='Pneu 19'>Pneu 19</option><option value='Pneu 20'>Pneu 20</option><option value='Pneu 21'>Pneu 21</option><option value='Piv??'>Piv??</option><option value='Refil'>Refil</option><option value='Remendo frio'>Remendo frio</option><option value='Remendo quente'>Remendo quente</option><option value='Remendo de Camara'>Remendo de Camara</option><option value='Rebaixamento'>Rebaixamento</option><option value='Roda'>Roda</option><option value='Rod??zio'>Rod??zio</option><option value='Rolamento dianteiro'>Rolamento dianteiro</option><option value='Rolamento trazeiro'>Rolamento trazeiro</option><option value='Socorro'>Socorro</option><option value='Troca'>Troca</option><option value='Troca de bico'>Troca de bico</option><option value='Troca de calota'>Troca de calota</option><option value='Terminal de dire????o'>Terminal de dire????o</option><option value='Venda de pneu 13'>Venda de pneu 13</option><option value='Venda de pneu 14'>Venda de pneu 14</option><option value='Venda de pneu 15'>Venda de pneu 15</option><option value='Venda de pneu 16'>Venda de pneu 16</option><option value='Venda de pneu 17'>Venda de pneu 17</option><option value='Venda de pneu 18'>Venda de pneu 18</option><option value='Venda de pneu 19'>Venda de pneu 19</option><option value='Venda de pneu 20'>Venda de pneu 20</option><option value='Venda de pneu 21'>Venda de pneu 21</option><option value='Venda de roda'>Venda de roda</option><option value='Venda de Acess??rio'>Venda de Acess??rio</option><option value='Vulcanizo'>Vulcanizo</option><option value='Veda????o'>Veda????o</option></select>"
				+ "<select onChange='SENAI.biblioteca.selectQnt(this)' name='quantidade' id='quantidade"+linhas+"' autocomplete='off'"
				+ "minlength='3' maxlength='25' maxlength='25'><option value='1'>x1</option><option value='2'>x2</option><option value='3'>x3</option><option value='4'>x4</option><option value='5'>x5</option><option value='6'>x6</option><option value='7'>x7</option><option value='8'>x8</option><option value='9'>x9</option><option value='10'>x10</option></select><input class='form-control' id='item"+linhas+"' onblur= 'SENAI.biblioteca.blur(this)' autocomplete='off' placeholder='R$ (Valor Unit??rio)'><label class='control-label'></label></div>";
						
							div.appendChild(divtest);
							
							
							
							if(linhas>0){
								
								
								for(i = 0; i < (linhas+1); i++){
									var conc = [];
									conc[i] = document.getElementById("item"+(i));
							
									if(parseFloat(conc[i].value) > 0){
											var qtd = document.getElementById("quantidade"+(i));
											var doc = qtd.value;
											
												soma += parseFloat(conc[i].value*doc);
											
											
										
									}
																$("#item"+(i)).maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});

							}
							soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
							document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
							soma = 0;
							}
							
							
							
					}
					
					var soma = 0;
					var outrasoma = "";
					
					SENAI.biblioteca.selectQnt = function(valor){
						for(i = 0; i < (linhas+1); i++){
							var conc = [];
							conc[i] = document.getElementById("item"+(i));
							
							if(parseFloat(conc[i].value)> 0){
								
								
								var qtd = document.getElementById("quantidade"+(i));
								var doc = qtd.value;
								
								
									soma += (conc[i].value*doc);
								
								
							}
							
							
						}
						
						soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
						document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
						soma = 0;
						
					}
					
					SENAI.biblioteca.outroblur = function(valor){
						
						
						
						soma = 0;
						var atual = valor.value;			
						var cur_re = /\D*(\d+|\d.*?\d)(?:\D+(\d{2}))?\D*$/;
						var parts = cur_re.exec(atual);
						var number = parseFloat(parts[1].replace(/\D/,'')+'.'+(parts[2]?parts[2]:'00'));
						valor.value = (number.toFixed(2));
						
						

						for(i = 0; i < (linhas+1); i++){
							var conc = [];
							conc[i] = document.getElementById("item"+(i));
							
							if(parseFloat(conc[i].value)> 0){
								
								var qtd = document.getElementById("quantidade"+(i));
								
								var doc = qtd.value;
								
									
								soma += parseFloat(conc[i].value*doc);
								
							}
							
							$("#item"+(i)).maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});

							
						}
						
						soma = soma - valor.value;
						if(soma < 0){
							soma = 0;
						}
				
							document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
						
						soma = 0;
						
					}
					
					SENAI.biblioteca.blur = function(valor){
						
						
						
						soma = 0;
						var atual = valor.value;			
						var cur_re = /\D*(\d+|\d.*?\d)(?:\D+(\d{2}))?\D*$/;
						var parts = cur_re.exec(atual);
						var number = parseFloat(parts[1].replace(/\D/,'')+'.'+(parts[2]?parts[2]:'00'));
						valor.value = (number.toFixed(2));
							
							
							
							
			
						for(i = 0; i < (linhas+1); i++){
							var conc = [];
							conc[i] = document.getElementById("item"+(i));
							
							if(parseFloat(conc[i].value)> 0){
								
								var qtd = document.getElementById("quantidade"+(i));
								
								var doc = qtd.value;
								
									
								soma += parseFloat(conc[i].value*doc);
								
							}
							
							$("#item"+(i)).maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});

							
						}
						
						soma = soma - document.getElementById("inputvalordesc").value;
						if(soma < 0){
							soma = 0;
						}
				
							document.getElementById("inputvalor").value = "R$ "+soma.toFixed(2);
						
							
						soma = 0;
					}
					
					

					SENAI.biblioteca.exibirServicos(undefined, "");

					SENAI.biblioteca.verificaResult = function(valor){

					document.getElementById("searchDate").value = "dd/mm/aaaa";
					document.getElementById("searchDate2").value = "dd/mm/aaaa";
						
						var metodo = 0;
						if(valor.value == 0){
							SENAI.biblioteca.buscarServico();
						}else if(valor.value == 1){
							SENAI.biblioteca.buscarServHj();
						}else if(valor.value == 2){
							metodo = 0;
							SENAI.biblioteca.buscarServMes(metodo);
						}else if(valor.value == 3){
							metodo = 1;
							SENAI.biblioteca.buscarServHjTipo(metodo);
						}else if(valor.value == 4){
							metodo = 2;
							SENAI.biblioteca.buscarServHjTipo(metodo);
						}else if(valor.value == 5){
							metodo = 3;
							SENAI.biblioteca.buscarServHjTipo(metodo);
						}else if(valor.value == 6){
							metodo = 4;
							SENAI.biblioteca.buscarServHjTipo(metodo);
						}else if(valor.value == 7){
							metodo = 1;
							SENAI.biblioteca.buscarServMes(metodo);
						}else if(valor.value == 8){
							metodo = 2;
							SENAI.biblioteca.buscarServMes(metodo);
						}else if(valor.value == 9){
							metodo = 3;
							SENAI.biblioteca.buscarServMes(metodo);
						}else if(valor.value == 10){
							metodo = 4;
							SENAI.biblioteca.buscarServMes(metodo);
						}
					}

					SENAI.biblioteca.deletarServico = function(id) {
						msg = "Tem certeza que deseja excluir este servi??o?"
							var cfg = {
									title : "Mensagem",
									height : 250,
									width : 400,
									modal : true,
									buttons : {
										"N??o" : function() {
											$(this).dialog("close");
										},
										"Sim" : function(){
											var cfg = {
												type : "POST",
												url : "../../rest/bibliotecaRest/deletarServico/"
														+ id,
												success : function(msg) {
													var qtLinhas = $("#resultadoServicos tr").length;
													$(this).parents("tr").remove();
													$("#add-new").removeAttr("disabled");
													var cfg = {
														title : "Mensagem",
														height : 250,
														width : 400,
														modal : true,
														buttons : {
															"OK" : function() {
																$(this).dialog("close");
															}
														}
													};
					
													$("#msg").html(msg);
													$("#msg").dialog(cfg);
					
													if(document.getElementById("selectFiltro").value != 50){
														var valor = document.getElementById("selectFiltro");
														SENAI.biblioteca.verificaResult(valor);
													}else{
														SENAI.biblioteca.buscarServ();
													}
												},
												error : function(err) {
													alert("Erro: "
															+ err.responseText);
												}
											};
											SENAI.ajax.post(cfg);
										}
									}
								};
						$("#msg").html(msg);
						$("#msg").dialog(cfg);
					}

					SENAI.biblioteca.editarServico = function(id) {
					
						var cfg = {
							type : "POST",
							url : "../../rest/bibliotecaRest/buscarServicoPeloId/"
									+ id,
							success : function(servico) {
								var servicovalor = servico.valor;
								$("#idServicoEdit").val(servico.id);
								$("#servicoEdit").val(servico.servico);
								$("#observacaoEdit").val(servico.observacao);
								$("#marcaEdit").val(servico.marca);
								$("#modeloEdit").val(servico.modelo);
								$("#placaEdit").val(servico.placa);
								$("#valorEdit").val("R$ "+servicovalor.toFixed(2));
								$("#metodoEdit").val(servico.metodo);
								$("#dataEdit").val(servico.data);
								SENAI.biblioteca.exibirEdicao(servico);
							},
							error : function(err) {
								alert("Erro ao editar o servi??o!"
										+ err.responseText);
							}
						};
						SENAI.ajax.post(cfg);
						$("#valorEdit").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});

					};
					

					SENAI.biblioteca.exibirEdicao = function(servico) {
						var cfg = {
							title : "Visualizar Servi??o",
							height : 830,
							width : 850,
							modal : true,
							buttons : {
								"OK" : function() {
									$(this).dialog("close");
								},
							},
							close : function() {
							}
						};
						$("#editarServico").dialog(cfg);
					};
					
					
					///////////
					
					SENAI.biblioteca.imprimirServico = function(id) {
							
						
											var cfg = {
												type : "POST",
												url : "../../rest/bibliotecaRest/buscarServicoPeloId/"
														+ id,
												success : function(servico) {
													
													
													$("#test").html("<div id='datahr'><span>Data: "+servico.data+"</span><br><span>Hora: "+servico.horario+"</span><br><br><br><br></div><div id='itensxd'></div><div><span class='form-payment-price' data-wrapper-react='true'>"+servico.servico+"</span><br><br><br><br></div><span class='form-payment-total'> <b> <span id='total-text'> Total </span> ?? <span class='form-payment-price'> <span data-wrapper-react='true'> R$ <span id='payment_total'> "+servico.valor.toFixed(2)+" </span> </span> </span> </b> </span>");
													
												
												},
												error : function(err) {
													alert("Erro ao editar o servi??o!"
															+ err.responseText);
												}
											};
											SENAI.ajax.post(cfg);
								
								
      							
      						

					};
					
					function print() {
						        var frame = document.getElementById('frame');
						        frame.contentWindow.focus();
						        frame.contentWindow.print();
						    }
						    
						    document.getElementById("btnPrint").onclick = function () {
    printElement(document.getElementById("printThis"));
}

function printElement(elem) {
    var domClone = elem.cloneNode(true);
    
    var $printSection = document.getElementById("printSection");
    
    if (!$printSection) {
        var $printSection = document.createElement("div");
        $printSection.id = "printSection";
        document.body.appendChild($printSection);
    }
    
    $printSection.innerHTML = "";
    $printSection.appendChild(domClone);
    window.print();
}

					SENAI.biblioteca.exibirImpressao = function(servico) {
						var cfg = {
							title : "Imprimir Servi??o",
							height : 900,
							width : 900,
							modal : true,
							buttons : {
								"OK" : function() {
									$(this).dialog("close");
								},
							},
							close : function() {
							}
						};
						$("#MyModal").dialog(cfg);
					};
 
					
					SENAI.biblioteca.buscarServHjTipo = function(metodo){
						
								
						var valorBusca = dataHj;
						SENAI.biblioteca.exibirServicosDataHj(undefined, valorBusca, metodo);
					}	
					
		
		SENAI.biblioteca.teste = function(valor){
			
			var atual = valor.value;			
			var cur_re = /\D*(\d+|\d.*?\d)(?:\D+(\d{2}))?\D*$/;
			var parts = cur_re.exec(atual);
			var number = parseFloat(parts[1].replace(/\D/,'')+'.'+(parts[2]?parts[2]:'00'));
			valor.value = (number.toFixed(2));
			
		}
				
				});