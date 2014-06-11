package models;



public class Empresa {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cnpj;
	private String telefone;
	private String end;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEnd() {
		return end;
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

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	    
    
}