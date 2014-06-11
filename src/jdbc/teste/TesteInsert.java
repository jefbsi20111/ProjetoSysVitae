package jdbc.teste;

import dao.CandidatoDAO;
import models.Candidato;

public class TesteInsert {

	public static void main(String[] args) throws Throwable {
		Candidato c = new Candidato();
		 
		c.setNome("morais");
		c.setEmail("jefbsi2011.1@hotmail.com");
		c.setSenha("concursos");
		c.setData_nasc("11/01/1998");
		c.setCpf("66666323");
		c.setEnd("Carnaubas");		
		c.setTelefone("4668643");
		c.setEscolaridade(3);
		c.setExp("tecnico das computarias");
		c.setArea_atuacao("info");
		c.setApendices("PCIConcursos");
		 // grave nessa conexão!!!
		 CandidatoDAO dao = new CandidatoDAO();
		 
		 // método elegante
		 dao.adicionar(c);
		 
		 System.out.println("Gravado!");

	}

}
