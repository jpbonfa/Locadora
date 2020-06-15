  package model;

public class Cliente {

	private int codigo;
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String rg;
	private Data dataDeNascimento;
	private int idade;
	private char sexo;
	private String telefone;
	private String celular;
	private String Email;

	public Cliente() {
	}

	public Cliente(int codigo, String nome, Endereco endereco, String cpf, String rg, Data dataDeNascimento, int idade,
			char sexo, String telefone, String celular, String email) {
		;
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.rg = rg;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		Email = email;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Data getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Data dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
