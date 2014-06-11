package jdbc.teste;

import dao.CandidatoDAO;

public class TestRemove {

	public static void main(String[] args) throws ClassNotFoundException {
		String s = "primeiro doido";
		CandidatoDAO dao = new CandidatoDAO();
		dao.remover(s);

	}

}
