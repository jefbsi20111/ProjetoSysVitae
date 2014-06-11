package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.itextpdf.text.DocumentException;

import dao.CandidatoDAO;
import negocio.GeradorPDF;
import models.Candidato;
import models.User;

/**
 * Servlet implementation class GerarPDF
 */
//@WebServlet("/GerarPDF")
@WebServlet(name="gerar-pdf", urlPatterns={"/templates/candidato/gerar-pdf"})
public class GerarPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerarPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;  	
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("User");
		  
		Candidato candidato = new Candidato();
		CandidatoDAO daoCandidato = null;
		try {
			  daoCandidato = new CandidatoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String emailSession = user.getEmail();
		
		candidato = daoCandidato.filtro_email(emailSession);
		
		String nome = candidato.getNome(); 
		String email = candidato.getEmail();
		String senha = candidato.getSenha();
		String cpf = candidato.getCpf();
		String end = candidato.getEnd();
		String telefone = candidato.getTelefone();
		int esc = candidato.getEscolaridade();
		String exp = candidato.getExp();
		String area = candidato.getArea_atuacao();
		String apendices = candidato.getApendices();

		candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setEmail(email);
		candidato.setSenha(senha);
		candidato.setCpf(cpf);
		candidato.setEnd(end);
		candidato.setTelefone(telefone);
		candidato.setEscolaridade(esc);
		candidato.setExp(exp);
		candidato.setArea_atuacao(area);
		candidato.setApendices(apendices);
		
		GeradorPDF pdf = new GeradorPDF();
		try {
			pdf.criarDocumento(candidato);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
