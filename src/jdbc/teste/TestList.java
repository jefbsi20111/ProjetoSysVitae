package jdbc.teste;

import java.text.ParseException;
import java.util.List;

import models.Candidato;
import dao.CandidatoDAO;




public class TestList {

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
		CandidatoDAO dao = new CandidatoDAO();
		List<Candidato> candidatos = dao.listar();
		
		for (Candidato candidato : candidatos) {
			System.out.println("S�rie Cadastro: " + candidato.getId());
			System.out.println("Nome: " + candidato.getNome());
			System.out.println("Email: " + candidato.getEmail());
			System.out.println("Senha: " + candidato.getSenha());
			System.out.println("Data Nasc: " + candidato.getData_nasc());
			System.out.println("CPF: " + candidato.getCpf());
			System.out.println("Endere�o: " + candidato.getEnd());
			System.out.println("Telefone: " + candidato.getTelefone());
			System.out.println("Escolaridade: " + candidato.getEscolaridade());
			System.out.println("Area Atua��o: " + candidato.getArea_atuacao());
			System.out.println("Experi�ncias: " + candidato.getExp());
			System.out.println("Apendices: " + candidato.getApendices());
			System.out.println("-----------------\n");
			}


	}

}
