package model;

import util.Util;

public class Data {

	private int dia;
	private int mes;
	private int ano;

	public Data() {
	}

	public Data(int dia, int mes, int ano) {

		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Data(String data) {
		int aux[] = Util.quebraData(data);
		this.dia = aux[0];
		this.mes = aux[1];
		this.ano = aux[2];
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		String dia = "", mes = "";
		if (this.dia < 10) {
			dia = "0" + this.dia;
		}
		if (this.mes < 10) {
			mes = "0" + this.mes;
		}
		return dia + "/" + mes + "/" + this.ano;
	}

}
