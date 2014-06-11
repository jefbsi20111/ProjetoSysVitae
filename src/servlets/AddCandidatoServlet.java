package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.CandidatoDAO;
import models.Candidato;

@WebServlet(name="cadastrar-candidato", urlPatterns={"/templates/candidato/cadastrar-candidato"})
public class AddCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String end = req.getParameter("end");
		String escolaridade = req.getParameter("escolaridade");
		String exp = req.getParameter("exp");
		String area = req.getParameter("area");
		String apendices = req.getParameter("apendices");

		Candidato candidato;

		candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setEmail(email);
		candidato.setSenha(senha);
		candidato.setCpf(cpf);
		candidato.setEnd(end);
		candidato.setTelefone(telefone);
		int esc = Integer.parseInt(escolaridade);
		candidato.setEscolaridade(esc);
		candidato.setExp(exp);
		candidato.setArea_atuacao(area);
		candidato.setApendices(apendices);
		
		CandidatoDAO cadastraCandidato;
		try {
			cadastraCandidato = new CandidatoDAO();
			cadastraCandidato.adicionar(candidato);
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//req.getRequestDispatcher("index.jsp").forward(req, resp);

	}
}
