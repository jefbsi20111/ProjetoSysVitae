package jdbc.teste;

import models.Candidato;
import dao.CandidatoDAO;

public class TestFiltroEmail {

	public static void main(String[] args) throws ClassNotFoundException {
		CandidatoDAO dao = new CandidatoDAO();
		Candidato candidato = new Candidato();
		candidato = dao.filtro_email("eu@eu.com");
		
		System.out.println("Série Cadastro: " + candidato.getId());
		System.out.println("Nome: " + candidato.getNome());
		System.out.println("Email: " + candidato.getEmail());
		System.out.println("Senha: " + candidato.getSenha());
		System.out.println("Data Nasc: " + candidato.getData_nasc());
		System.out.println("CPF: " + candidato.getCpf());
		System.out.println("Endereço: " + candidato.getEnd());
		System.out.println("Telefone: " + candidato.getTelefone());
		System.out.println("Escolaridade: " + candidato.getEscolaridade());
		System.out.println("Area Atuação: " + candidato.getArea_atuacao());
		System.out.println("Experiências: " + candidato.getExp());
		System.out.println("Apendices: " + candidato.getApendices());
		System.out.println("-----------------\n");

	}

}
