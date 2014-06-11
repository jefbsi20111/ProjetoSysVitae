package jdbc.teste;

import java.util.List;

import models.Vaga;
import dao.VagaDAO;


public class TestListaVaga {

	public static void main(String[] args) throws ClassNotFoundException {
		VagaDAO dao = new VagaDAO();
		List<Vaga> vagas= dao.listar();

		for (Vaga vaga : vagas) {
		System.out.println("Série vaga: " + vaga.getId());
		System.out.println("Desc: " + vaga.getDescricao());
		System.out.println("Remun: " + vaga.getRemuneracao());
		System.out.println("Carga: " + vaga.getCarga_horaria());
		System.out.println("Requisitos: " + vaga.getRequisitos());
		System.out.println("EmailEm: " + vaga.getEmpresa_email_empresa());
		System.out.println("IdEm: " + vaga.getEmpresa_id_empresa());
		System.out.println("-----------------\n");
		}
	}

	

}
