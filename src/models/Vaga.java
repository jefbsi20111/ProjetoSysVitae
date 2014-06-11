package models;

public class Vaga {
	
	private Long id;
	private int carga_horaria;
	private float remuneracao;
	private String requisitos;
	private String descricao;
	private Long Empresa_id_empresa;
	private String Empresa_email_empresa;
	public Long getId() {
		return id;
	}
	public int getCarga_horaria() {
		return carga_horaria;
	}
	
	public float getRemuneracao() {
		return remuneracao;
	}
	
	public String getRequisitos() {
		return requisitos;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Long getEmpresa_id_empresa() {
		return Empresa_id_empresa;
	}
	
	public String getEmpresa_email_empresa() {
		return Empresa_email_empresa;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	public void setRemuneracao(float remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setEmpresa_id_empresa(Long empresa_id_empresa) {
		Empresa_id_empresa = empresa_id_empresa;
	}
	
	public void setEmpresa_email_empresa(String empresa_email_empresa) {
		Empresa_email_empresa = empresa_email_empresa;
	}
	
	public boolean equals(Vaga v) {
        if (v.getId() == this.id) {
            return true;
        } else {
            return false;
        }
    }

}
