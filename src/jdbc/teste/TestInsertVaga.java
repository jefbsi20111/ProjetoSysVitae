package jdbc.teste;

import dao.VagaDAO;
import models.Vaga;

public class TestInsertVaga {

	public static void main(String[] args) throws Throwable {
		Vaga vaga = new Vaga();
		vaga.setCarga_horaria(1);
		vaga.setRemuneracao(500);
		vaga.setRequisitos("ser foda");
		vaga.setDescricao("fazer bruxaria");
		vaga.setEmpresa_id_empresa((long) 1);
		vaga.setEmpresa_email_empresa("eu@minhaempresa.com");
		
		VagaDAO dao = new VagaDAO();
		dao.adicionar(vaga);
		System.out.println("Gravado!");
	}

}
