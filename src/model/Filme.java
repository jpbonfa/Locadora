package model;

public class Filme {

	private int codigo;
	private String nome;
	private String genero;
	private double valor;
	private boolean disponivel;
	private boolean promocao;
	private double valorDaPromocao;

	public Filme() {

	}

	public Filme(int codigo, String nome, String genero, double valor, boolean disponivel, boolean promocao,
			double valorDaPromocao) {

		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
		this.disponivel = disponivel;
		this.promocao = promocao;
		this.valorDaPromocao = valorDaPromocao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public double getValorDaPromocao() {
		return valorDaPromocao;
	}

	public void setValorDaPromocao(double valorDaPromocao) {
		this.valorDaPromocao = valorDaPromocao;
	}

}
