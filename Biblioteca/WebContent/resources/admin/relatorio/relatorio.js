SENAI.biblioteca = new Object();

$(document)
		.ready(
				function() {
					
					
					
						SENAI.biblioteca.exibirRelatorio = function(){
							
							
							
							var valorTotal = [];
							var valor = 0;
							var meses = [];
							var dataReal = "";
							var dataDividida = [];
							  var counts = 0;
							var dataDivididaInt = 0;
							 var d = new Date();
							  var n = (d.getMonth()+1);
							  var value = "";
							  
							  			var valorBusca = $("#valorBusca").val();
						var valorBusca2 = $("#valorBusca2").val();
						
						if(valorBusca == ""){
							valorBusca = null;
						}
						
						if(valorBusca2 == ""){
							valorBusca2 = null;
						}
						
			var valorTotal = [];
			
							var meses = [];
							var anos = [];
							var date = [];
							
						
							var cfg = {
									type : "GET",
									url : "../../rest/bibliotecaRest/buscarServicosDoMes/"+valorBusca+"/"+valorBusca2,
							success : function(relatorioServico) {
								
												for(var i = 0; i < relatorioServico.length; i++){
												
												
													
												
																valorTotal.push(relatorioServico[i].total.toFixed(2));
														
														meses.push(relatorioServico[i].mes);
														anos.push(relatorioServico[i].ano);
														date.push(relatorioServico[i].mes+"/"+relatorioServico[i].ano);
												
											
												
											}
												document.getElementsByClassName("line-chart2").innerHTML="";
											var ctx = document.getElementsByClassName("line-chart2");
											
											//type, data e options
											
											var chartGraph = new Chart(ctx, {
												type: 'line',
												
												data:{
													
													labels: date,
													
													datasets: [{
														
														label: "Total no mês",
														data: valorTotal,
														borderwidth: 6,
														borderColor: 'rgba(255, 99, 132)',
														backgroundColor: ['green', 'blue', 'yellow', 'red', 'Purple', 'Orange'],
													}]
												},
												options: {
													
													labels: {
														fontStyle: "bold"
													},
											        scales: {
											            yAxes: [{
											                ticks: {
											                    beginAtZero: true
											                }
											            }]
											        }
											    }
											
											});
		
										},
										error : function(err) {
											
										}
											
								};
								SENAI.ajax.post(cfg);
							
						   
						};
		
						
						
						
						SENAI.biblioteca.teste = function(){
							
							
							var data1 = new Date( $(valorBusca).val());
							var data2 = new Date( $(valorBusca2).val());
							let data = new Date(data1.getFullYear(), (data1.getMonth()+1), 0);
							let dataB = new Date(data2.getFullYear(), (data2.getMonth()+1), 0);
							

						
							let mesAtual1 = data1.getMonth()+1; //getMonth retorna um array dos meses que vai de 0 a 11, onde 0 é Janeiro, e 11 é Dezembro. a função "diasNoMesSearch" quer receber o numero do mes atual certo. por esses motivo tem +1 no final. 
							let diaAtual1 = data1.getDate(); //pega o dia atual.
							let anoAtual1 = data1.getFullYear(); //pega o ano completo
							let diasNoMes1 = data.getDate(); //chama a função!
							if (diaAtual1 === diasNoMes1){  
								   diaAtual1 = 1; //se tivermos no ultimo dia do mês. vamos setar 1 como dia seguinte!
								   mesAtual1 += 1;
								   if(mesAtual1 == 13){
									   mesAtual1 = 1;
									   anoAtual1 +=1;
								   }
								}else{
								   diaAtual1 += +1; //caso não estejamos no ultimo dia do mês, vamos fazer um incremento de +1.
								}
							
							 let mesAtual2 = data2.getMonth()+1; //getMonth retorna um array dos meses que vai de 0 a 11, onde 0 é Janeiro, e 11 é Dezembro. a função "diasNoMesSearch" quer receber o numero do mes atual certo. por esses motivo tem +1 no final. 
							
							

							 let diaAtual2 = data2.getDate(); //pega o dia atual.
							
							
							 let anoAtual2 = data2.getFullYear(); //pega o ano completo
							
							
							
							let diasNoMes2 = dataB.getDate(); //chama a função!
							if (diaAtual2 === diasNoMes2){  
								   diaAtual2 = 1; //se tivermos no ultimo dia do mês. vamos setar 1 como dia seguinte!
								   mesAtual2 += 1;
								   if(mesAtual2 == 13){
									   mesAtual2 = 1;
									   anoAtual2 +=1;
								   }
								}else{
								   diaAtual2 += +1; //caso não estejamos no ultimo dia do mês, vamos fazer um incremento de +1.
								}
							
							
							
							
						var valorBusca = $("#valorBusca").val();
						var valorBusca2 = $("#valorBusca2").val();
						
						
							var valorTotal = [];
			
							var meses = [];
							var anos = [];
							var date = [];
							
						if(valorBusca == null || valorBusca == ""){
							valorBusca = null;
						}	
						if(valorBusca2 == null || valorBusca2 == ""){
							valorBusca2 = null;
						}
						
							var cfg = {
									type : "GET",
									url : "../../rest/bibliotecaRest/buscarServicosDoMes/"+valorBusca+"/"+valorBusca2,
							
							success : function(relatorioServico) {
								
												for(var i = 0; i < relatorioServico.length; i++){
												
												
													
												
																valorTotal.push(relatorioServico[i].total.toFixed(2));
														
														meses.push(relatorioServico[i].mes);
														
														anos.push(relatorioServico[i].ano);
														
														date.push(relatorioServico[i].mes+"/"+relatorioServico[i].ano);
													
												
											
												
											}
												document.getElementsByClassName("line-chart2").innerHTML="";
											var ctx = document.getElementsByClassName("line-chart2");
											
											//type, data e options
											
											var chartGraph = new Chart(ctx, {
												type: 'line',
												
												data:{
													
													labels: date,
													datasets: [{
														
														label: "Total no Mês",
														data: valorTotal,
														borderwidth: 6,
														borderColor: 'rgba(255, 99, 132)',
														backgroundColor: ['green', 'blue', 'yellow', 'red', 'Purple', 'Orange'],
													}]
												},
												options: {
													
													labels: {
														fontStyle: "bold"
													},
											        scales: {
											            yAxes: [{
											                ticks: {
											                    beginAtZero: true
											                }
											            }]
											        }
											    }
											
											});
		
										},
										error : function(err) {
											
										}
											
								};
								SENAI.ajax.post(cfg);
							
						   
						};
						
						$('#downloadPdf').click(function(event) {
							  // get size of report page
							  var reportPageHeight = $('#reportPage').innerHeight();
							  var reportPageWidth = $('#reportPage').innerWidth();
							  
							  // create a new canvas object that we will populate with all other canvas objects
							  var pdfCanvas = $('<canvas />').attr({
							    id: "canvaspdf",
							    width: reportPageWidth,
							    height: reportPageHeight
							  });
							  
							  
							  
							  // keep track canvas position
							  var pdfctx = $(pdfCanvas)[0].getContext('2d');
							  var pdfctxX = 0;
							  var pdfctxY = 0;
							  var buffer = 0;
							  
							  // for each chart.js chart
							  $("canvas").each(function(index) {
							    // get the chart height/width
							    var canvasHeight = $(this).innerHeight();
							    var canvasWidth = $(this).innerWidth();
							    
							    // draw the chart into the new canvas
							    pdfctx.drawImage($(this)[0], pdfctxX, pdfctxY, canvasWidth, canvasHeight);
							    pdfctxX += canvasWidth + buffer;
							    
							    // our report page is in a grid pattern so replicate that in the new canvas
							    if (index % 2 === 1) {
							      pdfctxX = 0;
							      pdfctxY += canvasHeight + buffer;
							    }
							  });
							  
							  // create new pdf and add our new canvas as an image
							  var pdf = new jsPDF('l', 'pt', [reportPageWidth, reportPageHeight]);
							  pdf.addImage($(pdfCanvas)[0], 'PNG', 150, 0);
							  
							  // download the pdf
							  pdf.save('relatorio.pdf');
							  
							  /////////////////////////
							  
							  
							  
							});
						
	
						
						SENAI.biblioteca.exibirRelatorio();
				});