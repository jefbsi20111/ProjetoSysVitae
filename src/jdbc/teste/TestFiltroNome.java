package jdbc.teste;

import java.util.List;

import models.Candidato;
import dao.CandidatoDAO;

public class TestFiltroNome {

	public static void main(String[] args) throws ClassNotFoundException {
		String str = "ma";
		CandidatoDAO dao = new CandidatoDAO();
		List<Candidato> candidatos = dao.filtro_nome("%"+str+"%");
		
		for (Candidato candidato : candidatos) {
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


	}

