package br.com.BibliotecaRest.objetos;

import java.io.Serializable;

public class RelatorioServico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String ano;
	private String mes;
	private float total;
	



	
	public String getAno(){
		return ano;
	}
	
	public void setAno(String ano){
		this.ano = ano;
	}
	
	public String getMes(){
		return mes;
	}
	
	public void setMes(String mes){
		this.mes = mes;
	}
	

	
	public float getTotal(){
		return total;
	}
	
	public void setTotal(float total){
		this.total = total;
	}
}
