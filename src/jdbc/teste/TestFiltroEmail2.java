package jdbc.teste;

import models.Empresa;
import dao.EmpresaDAO;


public class TestFiltroEmail2 {

	public static void main(String[] args) throws ClassNotFoundException {
		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = new Empresa();
		empresa = dao.filtro_email("eu@minhaempresa.com");
		
		System.out.println("Série Cadastro: " + empresa.getId());
		System.out.println("Nome: " + empresa.getNome());
		System.out.println("Email: " + empresa.getEmail());
		System.out.println("Senha: " + empresa.getSenha());
		System.out.println("Data Nasc: " + empresa.getCnpj());
		System.out.println("Endereço: " + empresa.getEnd());
		System.out.println("Telefone: " + empresa.getTelefone());
		System.out.println("-----------------\n");

	}

}
