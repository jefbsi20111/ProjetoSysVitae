package models;



public class Candidato {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String data_nasc;
	private String cpf;
	private String end;
	private String telefone;
	private int escolaridade;
	private String exp;
	private String area_atuacao;
	private String apendices;
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEnd() {
		return end;
	}
	public String getTelefone() {
		return telefone;
	}
	public int getEscolaridade() {
		return escolaridade;
	}
	public String getExp() {
		return exp;
	}
	public String getArea_atuacao() {
		return area_atuacao;
	}
	public String getApendices() {
		return apendices;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Long getId() {
		return id;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEscolaridade(int escolaridade) {
		this.escolaridade = escolaridade;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public void setArea_atuacao(String area_atuacao) {
		this.area_atuacao = area_atuacao;
	}
	public void setApendices(String apendices) {
		this.apendices = apendices;
	}

	
}
