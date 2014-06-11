package jdbc.teste;

import models.Vaga;
import dao.VagaDAO;

public class TestFiltroVagasId {

	public static void main(String[] args) throws Throwable {
		Vaga vaga = new Vaga();
		VagaDAO dao = new VagaDAO();
		Long l = (long) 2;
		vaga = dao.filtro_vagas_id(l);
		System.out.println("Empresa: "+vaga.getEmpresa_email_empresa());
		System.out.println("S�rie Vaga: "+vaga.getId());
		System.out.println("Carga Hor�ria: "+vaga.getCarga_horaria());
		System.out.println("Remunera��o: "+vaga.getRemuneracao());
		System.out.println("Requisitos: "+vaga.getRequisitos());
		System.out.println("Descri��o: "+vaga.getDescricao());
		
		

	}
	

}
