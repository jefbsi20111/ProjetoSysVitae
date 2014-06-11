package jdbc.teste;

import java.text.ParseException;

import models.Candidato;
import dao.CandidatoDAO;

public class TestAlter {

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
		Candidato c = new Candidato();
		String email = "fulano@mail.hue";
		 
		c.setId((long) 1);
		c.setNome("Eduardo");
		c.setEmail("fulano@mail.hue");
		c.setSenha("parada");
		c.setData_nasc("22/05/1998");
		c.setCpf("666663333");
		c.setEnd("pertoDoPosto");		
		c.setTelefone("466343");
		c.setEscolaridade(3);
		c.setExp("programador front end");
		c.setArea_atuacao("em casa");
		c.setApendices("LekTronic");
		 // grave nessa conexão!!!
		CandidatoDAO dao = new CandidatoDAO();
		 
		 // método elegante
		 dao.alterar(c,email);

	}

}
